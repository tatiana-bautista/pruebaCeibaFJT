package com.ceiba.services.api.service.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.services.api.service.domain.Usuario;

public interface UsuarioRep extends CrudRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE nombre = ?1")
	List<Usuario> findByNombre(String nombre);
}
