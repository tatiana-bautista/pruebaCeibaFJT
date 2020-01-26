package com.ceiba.services.api.service.repos;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Prestamo;

public interface PrestamoRep extends CrudRepository<Prestamo, Long> {

}
