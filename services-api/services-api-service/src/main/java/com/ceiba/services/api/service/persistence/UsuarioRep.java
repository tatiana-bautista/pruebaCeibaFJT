package com.ceiba.services.api.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Usuario;

public interface UsuarioRep extends CrudRepository<Usuario, Long> {

}
