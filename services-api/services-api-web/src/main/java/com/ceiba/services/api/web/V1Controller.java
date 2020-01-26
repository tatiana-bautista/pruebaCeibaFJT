package com.ceiba.services.api.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.services.api.common.dto.ResponseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("services-api-web/v1")
@RequiredArgsConstructor
public class V1Controller {

	@GetMapping("/echo")
	public ResponseEntity<ResponseService> echo() throws Exception {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
