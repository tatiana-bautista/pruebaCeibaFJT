package com.ceiba.services.api.service.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Prestamo;

public interface PrestamoRep extends CrudRepository<Prestamo, Long> {

}
