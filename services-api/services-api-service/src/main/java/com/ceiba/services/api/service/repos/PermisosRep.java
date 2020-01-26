package com.ceiba.services.api.service.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.services.api.service.domain.Permisos;

@Repository
public interface PermisosRep extends CrudRepository<Permisos, Integer> {

}
