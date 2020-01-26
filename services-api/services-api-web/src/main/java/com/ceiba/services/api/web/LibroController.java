package com.ceiba.services.api.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.services.api.service.common.dto.RequestService;
import com.ceiba.services.api.service.common.dto.ResponseService;
import com.ceiba.services.api.service.port.in.LibroUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("services-api-web/libro")
@RequiredArgsConstructor
public class LibroController {
	private LibroUseCase libro;

	@GetMapping("/consultar")
	public ResponseEntity<ResponseService> consultar(@Valid @RequestBody RequestService req) throws Exception {
		return new ResponseEntity<>(libro.consultar(req), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<ResponseService> crear(@Valid @RequestBody RequestService req) throws Exception {
		return new ResponseEntity<>(libro.crear(req), HttpStatus.OK);
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<ResponseService> eliminar(@Valid @RequestBody RequestService req) throws Exception {
		return new ResponseEntity<>(libro.eliminar(req), HttpStatus.OK);
	}

	@PutMapping("/prestar")
	public ResponseEntity<ResponseService> prestar(@Valid @RequestBody RequestService req) throws Exception {
		return new ResponseEntity<>(libro.prestar(req), HttpStatus.OK);
	}

}
