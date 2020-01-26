package com.ceiba.services.api.service.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroDto {
	private String id;
	private String isbn;
	private String nombre;
	private String estado;
	private String ejemplar;
}
