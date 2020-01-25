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
			//buscar en bd libro por isbn
		} else if (!req.getNombre().isEmpty()) {
			//buscar en bd libreo por nombre
		} else if (!req.getEstado().isEmpty()) {
			//buscar en bd libro por estado
		} else 
			//devolver todos
			;
		return null;
	}

	@Override
	public ResponseService crear(RequestService req) {
		//buscar si existe el isbn, obtener el mayor ejemplar
		
		return null;
	}

	@Override
	public ResponseService eliminar(RequestService req) {
		//buscar el id del mayor ejemplar y borrarlo 
		return null;
	}

	@Override
	public ResponseService prestar(RequestService req) {
		//validar si el isbn del libro es palidrome ("los libros palíndromos solo se pueden utilizar en la biblioteca")
		//validar si el los digitos suman mas de 30y calcular fechaEntregaMaxima (15 dias, tener en cuenta fines de semana)
		//insertar en la tabla prestamo
		return null;
	}

}
