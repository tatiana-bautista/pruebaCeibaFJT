package com.ceiba.services.api.service.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.services.api.service.domain.Opcion;

@Repository
public interface OpcionRep extends CrudRepository<Opcion, Integer> {

}
