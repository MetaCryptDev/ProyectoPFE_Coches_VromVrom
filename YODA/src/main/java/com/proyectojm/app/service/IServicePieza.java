package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.PiezaDto;

public interface IServicePieza {

	
	public void guardarPieza(PiezaDto pieza);
	public void modificarPieza(PiezaDto pieza);
	public void eliminarPieza(Integer id);
	public List<PiezaDto> recuperarTodosLasPiezas();
	public PiezaDto recuperarUnaPieza(Integer id);
	
}
