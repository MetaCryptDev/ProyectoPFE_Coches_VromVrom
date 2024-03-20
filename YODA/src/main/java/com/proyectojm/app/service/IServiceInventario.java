package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.InventarioDto;

public interface IServiceInventario {

	void guardarPieza(InventarioDto pieza);
	void modificarPieza(InventarioDto pieza);
	void eliminarPieza(Integer id);
	List<InventarioDto> recuperarTodasLasPiezas();
	InventarioDto recuperarUnaPieza(Integer id);
	List<InventarioDto> buscador(String descripcion);

}
