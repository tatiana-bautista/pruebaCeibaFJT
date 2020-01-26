package com.ceiba.services.api.service.port.out;

import java.util.List;

import com.ceiba.services.api.service.domain.Usuario;

public interface UsuarioPort {
	Usuario getUsuario(Long id) throws UsuarioNotFoundException;

	class UsuarioNotFoundException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		public UsuarioNotFoundException() {
			super("Usuario not found!");
		}
	}

	List<Usuario> getUsuarios() throws UsuariosEmptyException;

	class UsuariosEmptyException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		public UsuariosEmptyException() {
			super("Usuarios is empty!");
		}
	}

	List<Usuario> getUsuariosByNombre(String nombre) throws UsuariosEmptyException;
}
