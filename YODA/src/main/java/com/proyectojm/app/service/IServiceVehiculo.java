package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.VehiculoDto;

public interface IServiceVehiculo {

    public void guardarVehiculo(VehiculoDto vehiculo);
    public void modificarVehiculo(VehiculoDto vehiculo);
    public void eliminarVehiculo(Integer id);
    public List<VehiculoDto> recuperarTodosLosVehiculos();
    public VehiculoDto recuperarUnVehiculo(Integer id);

}
