package com.ceiba.services.api.service.persistence;

import org.springframework.stereotype.Component;

import com.ceiba.services.api.service.common.PersistenceAdapter;
import com.ceiba.services.api.service.port.out.PerfilPort;
import com.ceiba.services.api.service.repos.PerfilRep;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class PerfilPersistence implements PerfilPort {
	private final PerfilRep perfilRepository;

}
