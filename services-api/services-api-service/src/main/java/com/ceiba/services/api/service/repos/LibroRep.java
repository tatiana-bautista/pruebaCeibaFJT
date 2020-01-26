package com.ceiba.services.api.service.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.services.api.service.domain.Libro;

@Repository
public interface LibroRep extends CrudRepository<Libro, Integer> {
	@Query("SELECT l FROM Libro l WHERE nombre = ?1")// ORDER BY nombre, ejemplar
	List<Libro> findByNombre(String nombre);

	@Query("SELECT l FROM Libro l WHERE nombre = ?1 and estado =?2")// ORDER BY nombre, ejemplar
	List<Libro> findByNombreAndEstado(String nombre, String estado);

	@Query("SELECT l FROM Libro l WHERE isbn = ?1")// ORDER BY ejemplar
	List<Libro> findByISBN(String isbn);

	@Query("SELECT l FROM Libro l WHERE isbn = ?1 and estado = ?2")// ORDER BY ejemplar
	List<Libro> findByIsbnAndEstado(String isbn, String estado);

	@Query("SELECT l FROM Libro l WHERE estado = ?1")// ORDER BY nombre, ejemplar
	List<Libro> findByEstado(String estado);
}
