package com.proyectojm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOVehiculoSustitucion;
import com.proyectojm.app.dto.VehiculoSustitucionDto;
import com.proyectojm.app.entities.VehiculoSustitucionEntity;
import com.proyectojm.app.service.IServiceVehiculoSustitucion;

@Service
public class VehiculoSustitucionServiceImpl implements IServiceVehiculoSustitucion {

    @Autowired
    private IDAOVehiculoSustitucion vehiculoSustitucionDao;

    @Override
    public void guardarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion) {
        // Implementa la lógica para guardar un vehículo de sustitución
    }

    @Override
    public void modificarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion) {
        // Implementa la lógica para modificar un vehículo de sustitución
    }

    @Override
    public void eliminarVehiculoSustitucion(Integer id) {
        // Implementa la lógica para eliminar un vehículo de sustitución por su ID
    }

    @Override
    public List<VehiculoSustitucionDto> recuperarTodosLosVehiculosSustitucion() {
        // Implementa la lógica para recuperar todos los vehículos de sustitución
        return null; // Cambia esto para devolver la lista real de vehículos de sustitución
    }

    @Override
    public VehiculoSustitucionDto recuperarUnVehiculoSustitucion(Integer id) {
        // Implementa la lógica para recuperar un vehículo de sustitución por su ID
        return null; // Cambia esto para devolver el vehículo de sustitución real
    }
}
