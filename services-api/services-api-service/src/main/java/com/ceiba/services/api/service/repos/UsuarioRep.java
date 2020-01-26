package com.ceiba.services.api.service.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.services.api.service.domain.Usuarios;

@Repository
public interface UsuarioRep extends CrudRepository<Usuarios, Integer> {

	@Query("SELECT u FROM Usuario u WHERE nombre = ?1")
	List<Usuarios> findByNombre(String nombre);
}
