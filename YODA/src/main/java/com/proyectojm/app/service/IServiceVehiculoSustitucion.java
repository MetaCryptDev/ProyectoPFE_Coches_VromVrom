package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.VehiculoSustitucionDto;

public interface IServiceVehiculoSustitucion {

    public void guardarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion);
    public void modificarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion);
    public void eliminarVehiculoSustitucion(Integer id);
    public List<VehiculoSustitucionDto> recuperarTodosLosVehiculosSustitucion();
    public VehiculoSustitucionDto recuperarUnVehiculoSustitucion(Integer id);

}
