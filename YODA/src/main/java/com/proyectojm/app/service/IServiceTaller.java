package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.TallerDto;

public interface IServiceTaller {

	
	public List<TallerDto> recuperarTodosLosTalleres();
	public TallerDto recuperarUnTaller(Integer id);
	
}
