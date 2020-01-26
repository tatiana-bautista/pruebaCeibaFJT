package com.ceiba.services.api.common.dto;

import java.util.List;

import com.ceiba.services.api.service.domain.Libro;
import com.ceiba.services.api.service.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseService {
	private String mensage;
	private String error;
	private Libro libro;
	private List<Libro> libros;
	private Usuario usuario;
	private List<Usuario> usuarios;
}
