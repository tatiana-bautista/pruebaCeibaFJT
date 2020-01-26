package com.ceiba.services.api.service.utils;

import com.ceiba.services.api.service.common.dto.LibroDto;
import com.ceiba.services.api.service.common.dto.UsuarioDto;
import com.ceiba.services.api.service.domain.Libro;
import com.ceiba.services.api.service.domain.Usuarios;

public class convert {
	public LibroDto libroToLibroDto(Libro l) {
		LibroDto resp = new LibroDto();
		if (l != null) {
			resp.setId(Integer.toString(l.getId()));
			resp.setIsbn(l.getIsbn());
			resp.setNombre(l.getNombre());
			resp.setEstado(l.getEstado());
			resp.setEjemplar(Integer.toString(l.getEjemplar()));
		}
		return resp;
	}

	public UsuarioDto usuarioToUsuarioDot(Usuarios u) {
		UsuarioDto resp = new UsuarioDto();
		if (u != null) {
			resp.setId(Integer.toString(u.getId()));
			resp.setNombre(u.getNombre());
			resp.setIdperfil(Integer.toString(u.getIdperfil()));
		}
		return resp;
	}
}
