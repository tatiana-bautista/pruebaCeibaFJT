package com.ceiba.services.api.service.persistence;

import com.ceiba.services.api.service.port.out.PerfilPort;
import com.ceiba.services.api.service.repos.PerfilRep;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PerfilPersistence implements PerfilPort {
	private final PerfilRep perfilRepository;

}
