package com.ceiba.services.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;
import com.ceiba.services.api.service.domain.Libro;
import com.ceiba.services.api.service.port.in.LibroUseCase;
import com.ceiba.services.api.service.port.out.LibroPort;
import com.ceiba.services.api.service.port.out.PrestamoPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroService implements LibroUseCase {
	private final LibroPort libroPort;
	private final PrestamoPort prestamoPort;

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
			if(l != null)
				if(libroPort.eliminar(l))
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

		// validar si el isbn del libro es palidrome ("los libros palíndromos solo se
		// pueden utilizar en la biblioteca")
		// validar si el los digitos suman mas de 30 y calcular fechaEntregaMaxima (15
		// dias, tener en cuenta fines de semana)
		// insertar en la tabla prestamo
		return null;
	}

}
