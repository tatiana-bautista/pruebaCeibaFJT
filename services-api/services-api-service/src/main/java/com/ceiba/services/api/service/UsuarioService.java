package com.ceiba.services.api.service;

import org.springframework.stereotype.Service;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;
import com.ceiba.services.api.service.port.in.UsuarioUseCase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioUseCase {
	@Override
	public ResponseService consultar(RequestService req) {
		// TODO Auto-generated method stub
		return null;
	}

}
