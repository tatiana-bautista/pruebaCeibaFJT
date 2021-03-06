package com.ceiba.services.api.service.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestService {
	private String id;
	private String nombre;
	private String isbn;
	private String estado;
	private String idLibro;
	private String idUsuario;
}
