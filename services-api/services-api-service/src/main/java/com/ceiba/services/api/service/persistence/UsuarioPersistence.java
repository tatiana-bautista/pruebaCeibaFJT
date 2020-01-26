package com.ceiba.services.api.service.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.ceiba.services.api.service.common.PersistenceAdapter;
import com.ceiba.services.api.service.domain.Usuarios;
import com.ceiba.services.api.service.port.out.UsuarioPort;
import com.ceiba.services.api.service.repos.UsuarioRep;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UsuarioPersistence implements UsuarioPort {
	private final UsuarioRep usuarioRepository;

	@Override
	public List<Usuarios> getUsuarios() {
		return StreamSupport.stream(usuarioRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Usuarios getUsuario(Integer id) {
		Usuarios resp = null;
		Optional<Usuarios> u = usuarioRepository.findById(id);
		if (u.isPresent())
			resp = u.get();
		return resp;
	}

	@Override
	public List<Usuarios> getUsuariosByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

}
