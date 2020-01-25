package com.ceiba.services.api.service;

import org.springframework.stereotype.Service;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;
import com.ceiba.services.api.service.port.in.LibroUseCase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroService implements LibroUseCase {
	@Override
	public ResponseService consultar(RequestService req) {
		if (!req.getIsbn().isEmpty()) {
			
		} else if (!req.getNombre().isEmpty()) {
			
		} else if (!req.getEstado().isEmpty()) {
			
		}
		return null;
	}

	@Override
	public ResponseService crear(RequestService req) {
		return null;
	}

	@Override
	public ResponseService eliminar(RequestService req) {
		return null;
	}

	@Override
	public ResponseService prestar(RequestService req) {
		return null;
	}

}
