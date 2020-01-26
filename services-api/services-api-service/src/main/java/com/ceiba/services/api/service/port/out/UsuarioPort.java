package com.ceiba.services.api.service.port.out;

import java.util.List;

import com.ceiba.services.api.service.domain.Usuarios;

public interface UsuarioPort {
	Usuarios getUsuario(Integer id) throws UsuarioNotFoundException;

	class UsuarioNotFoundException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		public UsuarioNotFoundException() {
			super("Usuario not found!");
		}
	}

	List<Usuarios> getUsuarios() throws UsuariosEmptyException;

	class UsuariosEmptyException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		public UsuariosEmptyException() {
			super("Usuarios is empty!");
		}
	}

	List<Usuarios> getUsuariosByNombre(String nombre) throws UsuariosEmptyException;
}
