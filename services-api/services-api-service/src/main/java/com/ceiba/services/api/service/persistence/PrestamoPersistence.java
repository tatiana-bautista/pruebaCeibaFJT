package com.ceiba.services.api.service.persistence;

import org.springframework.stereotype.Component;

import com.ceiba.services.api.service.common.PersistenceAdapter;
import com.ceiba.services.api.service.domain.Prestamo;
import com.ceiba.services.api.service.port.out.PrestamoPort;
import com.ceiba.services.api.service.repos.PrestamoRep;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class PrestamoPersistence implements PrestamoPort {
	private final PrestamoRep prestamoRepository;

	@Override
	public boolean nuevo(Prestamo p) {
		try {
			prestamoRepository.save(p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
