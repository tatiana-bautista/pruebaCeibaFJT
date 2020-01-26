package com.ceiba.services.api.service;

import org.springframework.stereotype.Service;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;
import com.ceiba.services.api.service.port.in.UsuarioUseCase;
import com.ceiba.services.api.service.port.out.UsuarioPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioUseCase {
	private final UsuarioPort usuarioPort;

	@Override
	public ResponseService consultar(RequestService req) {
		ResponseService resp = new ResponseService();
		if (!req.getId().isEmpty()) {
			resp.setUsuario(usuarioPort.getUsuario(Long.parseLong(req.getId())));
		} else if (!req.getNombre().isEmpty()) {
			resp.setUsuarios(usuarioPort.getUsuariosByNombre(req.getNombre()));
		} else
			resp.setUsuarios(usuarioPort.getUsuarios());
		return resp;
	}

}
