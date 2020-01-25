package com.ceiba.services.api.service.port.in;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;

public interface UsuarioUseCase {
	ResponseService consultar(RequestService req);
}
