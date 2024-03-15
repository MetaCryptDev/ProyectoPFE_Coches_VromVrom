package com.proyectojm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOVehiculo;
import com.proyectojm.app.dto.VehiculoDto;
import com.proyectojm.app.service.IServiceVehiculo;

@Service
public class VehiculoServiceImpl implements IServiceVehiculo {

    @Autowired
    private IDAOVehiculo vehiculoDao;

    @Override
    public void guardarVehiculo(VehiculoDto vehiculo) {
        // Implementa la lógica para guardar un vehículo
    }

    @Override
    public void modificarVehiculo(VehiculoDto vehiculo) {
        // Implementa la lógica para modificar un vehículo
    }

    @Override
    public void eliminarVehiculo(Integer id) {
        // Implementa la lógica para eliminar un vehículo por su ID
    }

    @Override
    public List<VehiculoDto> recuperarTodosLosVehiculos() {
        // Implementa la lógica para recuperar todos los vehículos
        return null; // Cambia esto para devolver la lista real de vehículos
    }

    @Override
    public VehiculoDto recuperarUnVehiculo(Integer id) {
        // Implementa la lógica para recuperar un vehículo por su ID
        return null; // Cambia esto para devolver el vehículo real
    }
}
