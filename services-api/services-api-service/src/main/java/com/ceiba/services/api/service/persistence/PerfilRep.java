package com.ceiba.services.api.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Perfil;

public interface PerfilRep extends CrudRepository<Perfil, Long> {

}
