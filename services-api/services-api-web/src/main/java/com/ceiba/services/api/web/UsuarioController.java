package com.ceiba.services.api.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.services.api.common.dto.RequestService;
import com.ceiba.services.api.common.dto.ResponseService;
import com.ceiba.services.api.service.port.in.UsuarioUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("services-api-web/usuario")
@RequiredArgsConstructor
public class UsuarioController {
	private UsuarioUseCase usuario;

	@GetMapping("/consultar")
	public ResponseEntity<ResponseService> consultar(@Valid @RequestBody RequestService req) throws Exception {
		return new ResponseEntity<>(usuario.consultar(req), HttpStatus.OK);
	}

}
