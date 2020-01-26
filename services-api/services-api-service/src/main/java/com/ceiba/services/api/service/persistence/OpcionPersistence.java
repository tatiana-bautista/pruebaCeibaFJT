package com.ceiba.services.api.service.persistence;

import com.ceiba.services.api.service.port.out.OpcionPort;
import com.ceiba.services.api.service.repos.OpcionRep;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OpcionPersistence implements OpcionPort {
	private final OpcionRep opcionRepository;

}
