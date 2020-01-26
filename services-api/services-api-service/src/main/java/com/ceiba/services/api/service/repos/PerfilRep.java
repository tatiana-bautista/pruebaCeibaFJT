package com.ceiba.services.api.service.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.services.api.service.domain.Perfil;

@Repository
public interface PerfilRep extends CrudRepository<Perfil, Integer> {

}
