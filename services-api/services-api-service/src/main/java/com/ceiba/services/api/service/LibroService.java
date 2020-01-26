package com.ceiba.services.api.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;
import com.ceiba.services.api.service.domain.Libro;
import com.ceiba.services.api.service.domain.Prestamo;
import com.ceiba.services.api.service.domain.Usuario;
import com.ceiba.services.api.service.port.in.LibroUseCase;
import com.ceiba.services.api.service.port.out.LibroPort;
import com.ceiba.services.api.service.port.out.PrestamoPort;
import com.ceiba.services.api.service.port.out.UsuarioPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroService implements LibroUseCase {
	private final LibroPort libroPort;
	private final PrestamoPort prestamoPort;
	private final UsuarioPort usuarioPort;

	@Override
	public ResponseService consultar(RequestService req) {
		ResponseService resp = new ResponseService();
		if (!req.getId().isEmpty()) {
			resp.setLibro(libroPort.getLibro(Long.parseLong(req.getId())));
		} else if (!req.getIsbn().isEmpty()) {
			if (!req.getEstado().isEmpty()) {
				resp.setLibros(libroPort.getLibrosIsbnEstado(req.getIsbn(), req.getEstado()));
			} else
				resp.setLibros(libroPort.getLibrosIsbn(req.getIsbn()));
		} else if (!req.getNombre().isEmpty()) {
			if (!req.getEstado().isEmpty()) {
				resp.setLibros(libroPort.getLibrosNombreEstado(req.getNombre(), req.getEstado()));
			} else
				resp.setLibros(libroPort.getLibrosNombre(req.getNombre()));
		} else if (!req.getEstado().isEmpty()) {
			resp.setLibros(libroPort.getLibrosEstado(req.getEstado()));
		} else
			resp.setLibros(libroPort.getLibros());
		return resp;
	}

	@Override
	public ResponseService crear(RequestService req) {
		ResponseService resp = new ResponseService();
		if (!req.getIsbn().isEmpty()) {
			Long ejemplar = 1L;
			Libro nuevo = new Libro();
			nuevo.setEstado("disponible");
			nuevo.setIsbn(req.getIsbn());
			List<Libro> ls = libroPort.getLibrosIsbn(req.getIsbn());

			if (!ls.isEmpty()) {
				Libro ult = ls.get(ls.size() - 1);
				ejemplar = ult.getEjemplar() + 1;
			}
			nuevo.setEjemplar(ejemplar);

			if (!req.getNombre().isEmpty()) {
				if (libroPort.nuevo(nuevo))
					resp.setMensage("libro creado satisfactoriamente");
				else
					resp.setError("error al intentar guardar el libro");
			} else
				resp.setError("se debe especificar el nombre");
		} else
			resp.setError("se debe especificar el codigo ISBN");
		return resp;
	}

	@Override
	public ResponseService eliminar(RequestService req) {
		ResponseService resp = new ResponseService();
		if (!req.getId().isEmpty()) {
			Libro l = libroPort.getLibro(Long.parseLong(req.getId()));
			if (l != null)
				if (libroPort.eliminar(l))
					resp.setMensage("libro eliminado satisfactoriamente");
				else
					resp.setError("libro no eliminado");
			else
				resp.setError("libro no encontrado");
		} else
			resp.setError("se debe especificar el codigo ISBN");
		return resp;
	}

	@Override
	public ResponseService prestar(RequestService req) {
		ResponseService resp = new ResponseService();
		if (!req.getIdLibro().isEmpty()) {
			Libro l = libroPort.getLibro(Long.parseLong(req.getIdLibro()));
			if (l != null) {
				if (!req.getIdUsuario().isEmpty()) {
					Usuario u = usuarioPort.getUsuario(Long.parseLong(req.getIdUsuario()));
					if (u != null) {
						if (!isPalindrome(l.getIsbn())) {
							Prestamo p = new Prestamo();
							p.setIdLibro(l.getId());
							p.setIdUsuario(u.getId());
							p.setFechaPrestamo(new Timestamp(new Date().getTime()));
							if (isGreaterThan(l.getIsbn(), 30))
								p.setFechaEntregaMaxima(
										new java.sql.Date(calculateMaxDate(Calendar.getInstance(), 15).getTime()));
							if (prestamoPort.nuevo(p)) {
								resp.setMensage("prestamo guardado satisfactoriamente");
							} else
								resp.setError("error al guardar prestamo");
						} else
							resp.setError("los libros palíndromos solo se pueden utilizar en la biblioteca");
					} else
						resp.setError("usuario no encontrado");
				} else
					resp.setError("se debe especificar el codigo id del usuario");
			} else
				resp.setError("libro no encontrado");
		} else
			resp.setError("se debe especificar el codigo id del libro");
		return resp;
	}

	private boolean isPalindrome(String word) {
		StringBuilder sb = new StringBuilder(word);
		String reverseWord = sb.reverse().toString();
		return word.equals(reverseWord);
	}

	private boolean isGreaterThan(String word, int max) {
		int sum = 0;
		for (int start = 0, end = word.length() - 1; start < end; ++start) {
			if (Character.isDigit(word.charAt(start)))
				sum += Character.getNumericValue(word.charAt(start));
		}
		return (sum > max);
	}

	private Date calculateMaxDate(Calendar fecha, int diffDays) {
		while (diffDays > 0) {
			if (fecha.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				diffDays--;
			}
			fecha.add(Calendar.DATE, 1);
		}
		return fecha.getTime();
	}

}
