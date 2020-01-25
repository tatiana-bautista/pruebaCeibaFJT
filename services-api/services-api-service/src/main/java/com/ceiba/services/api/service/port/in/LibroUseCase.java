package com.ceiba.services.api.service.port.in;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;

public interface LibroUseCase {
	ResponseService consultar(RequestService req);

	ResponseService crear(RequestService req);

	ResponseService eliminar(RequestService req);

	ResponseService prestar(RequestService req);
}
