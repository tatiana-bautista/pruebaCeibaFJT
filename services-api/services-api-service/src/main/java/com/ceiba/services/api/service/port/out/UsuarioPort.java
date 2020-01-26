package com.ceiba.services.api.service.port.out;

import java.util.List;

import com.ceiba.services.api.service.domain.Usuario;

public interface UsuarioPort {
	List<Usuario> getUsuarios() throws UsuariosEmptyException;

	class UsuariosEmptyException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		public UsuariosEmptyException() {
			super("Usuarios is empty!");
		}
	}

}
