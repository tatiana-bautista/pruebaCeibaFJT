package com.ceiba.services.api.service.port.in;

import com.ceiba.services.api.service.common.UseCase;
import com.ceiba.services.api.service.common.dto.RequestService;
import com.ceiba.services.api.service.common.dto.ResponseService;

@UseCase
public interface UsuarioUseCase {
	ResponseService consultar(RequestService req);
}
