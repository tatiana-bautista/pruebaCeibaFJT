package com.ceiba.services.api.service.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Libro;

public interface LibroRep extends CrudRepository<Libro, Long> {
	@Query("")
	Libro findByNombre(String nombre);

	@Query("")
	Libro findByISBN(String isbn);

	@Query("")
	Libro findByEstado(String estado);

	@Query("")
	Libro findByAll();
}
