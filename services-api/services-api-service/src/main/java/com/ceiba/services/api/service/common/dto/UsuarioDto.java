package com.ceiba.services.api.service.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
	private String id;
	private String nombre;
	private String pass;
	private String idperfil;
}
