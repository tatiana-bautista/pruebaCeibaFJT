package com.ceiba.services.api.service.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.ceiba.services.api.service.domain.Libro;
import com.ceiba.services.api.service.port.out.LibroPort;
import com.ceiba.services.api.service.repos.LibroRep;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LibroPersistence implements LibroPort {
	private final LibroRep libroRepository;

	@Override
	public List<Libro> getLibros() {
		return StreamSupport.stream(libroRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Libro getLibro(Long id) {
		Libro resp = null;
		Optional<Libro> l = libroRepository.findById(id);
		if (l.isPresent())
			resp = l.get();
		return resp;
	}

	@Override
	public List<Libro> getLibrosIsbn(String isbn) {
		return libroRepository.findByISBN(isbn);
	}

	@Override
	public List<Libro> getLibrosIsbnEstado(String isbn, String estado) {
		return libroRepository.findByIsbnAndEstado(isbn, estado);
	}

	@Override
	public List<Libro> getLibrosNombre(String nombre) {
		return libroRepository.findByNombre(nombre);
	}

	@Override
	public List<Libro> getLibrosNombreEstado(String nombre, String estado) {
		return libroRepository.findByNombreAndEstado(nombre, estado);
	}

	@Override
	public List<Libro> getLibrosEstado(String estado) {
		return libroRepository.findByEstado(estado);
	}

	@Override
	public boolean nuevo(Libro l) {
		try {
			libroRepository.save(l);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Libro l) {
		try {
			libroRepository.delete(l);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
