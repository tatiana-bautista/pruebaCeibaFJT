package com.ceiba.services.api.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Opcion;

public interface OpcionRep extends CrudRepository<Opcion, Long> {

}
