package com.ceiba.services.api.service.port.out;

import java.util.List;

import com.ceiba.services.api.service.domain.Libro;

public interface LibroPort {
	
	boolean nuevo(Libro l);
	
	List<Libro> getLibros() throws LibrosEmptyException;

	class LibrosEmptyException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		public LibrosEmptyException() {
			super("Libros is empty!");
		}
	}

	Libro getLibro(Long id) throws LibroNotFoundException;

	class LibroNotFoundException extends RuntimeException {
		private static final long serialVersionUID = -1L;

		public LibroNotFoundException() {
			super("Libro not found!");
		}
	}

	List<Libro> getLibrosIsbn(String isbn) throws LibrosEmptyException;

	List<Libro> getLibrosIsbnEstado(String isbn, String estado) throws LibrosEmptyException;

	List<Libro> getLibrosNombre(String nombre) throws LibrosEmptyException;

	List<Libro> getLibrosNombreEstado(String nombre, String estado) throws LibrosEmptyException;

	List<Libro> getLibrosEstado(String estado) throws LibrosEmptyException;
	
	boolean eliminar(Libro l);
}
