package com.ceiba.services.api.service.persistence;

import com.ceiba.services.api.service.port.out.PermisosPort;
import com.ceiba.services.api.service.repos.PermisosRep;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PermisosPersistence implements PermisosPort {
	private final PermisosRep permisosRepository;

}
