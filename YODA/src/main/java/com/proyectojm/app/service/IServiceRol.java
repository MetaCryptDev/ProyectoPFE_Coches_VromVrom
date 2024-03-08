package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.RolDto;

public interface IServiceRol {

	
	
	public List<RolDto> recuperarTodosLosRoles();
	public RolDto recuperarUnRol(Integer id);
	
}
