package com.ceiba.services.api.service.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.services.api.service.domain.Prestamo;

@Repository
public interface PrestamoRep extends CrudRepository<Prestamo, Integer> {

}
