package com.ceiba.services.api.service.persistence;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.ceiba.services.api.service.domain.Usuario;
import com.ceiba.services.api.service.port.out.UsuarioPort;
import com.ceiba.services.api.service.repos.UsuarioRep;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioPersistence implements UsuarioPort {
	private final UsuarioRep usuarioRepository;

	@Override
	public List<Usuario> getUsuarios() {
		return StreamSupport.stream(usuarioRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
