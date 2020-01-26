package com.ceiba.services.api.service.persistence;

import org.springframework.stereotype.Component;

import com.ceiba.services.api.service.common.PersistenceAdapter;
import com.ceiba.services.api.service.port.out.PermisosPort;
import com.ceiba.services.api.service.repos.PermisosRep;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class PermisosPersistence implements PermisosPort {
	private final PermisosRep permisosRepository;

}
