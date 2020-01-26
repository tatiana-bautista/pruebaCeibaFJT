package com.ceiba.services.api.service.persistence;

import com.ceiba.services.api.service.port.out.PrestamoPort;
import com.ceiba.services.api.service.repos.PrestamoRep;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrestamoPersistence implements PrestamoPort {
	private final PrestamoRep prestamoRepository;

}
