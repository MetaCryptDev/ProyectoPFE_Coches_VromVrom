package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.VehiculoSustitucionDto;

public interface IServiceVehiculoSustitucion {

	void eliminarVehiculoSustitucion(String matricula);

	void guardarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion);

	void modificarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion);

	List<VehiculoSustitucionDto> recuperarTodosLosVehiculosSustitucion();

	VehiculoSustitucionDto recuperarUnVehiculoSustitucion(String matricula);

}
