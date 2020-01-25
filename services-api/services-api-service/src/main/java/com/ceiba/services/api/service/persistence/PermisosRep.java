package com.ceiba.services.api.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Permisos;

public interface PermisosRep extends CrudRepository<Permisos, Long> {

}
