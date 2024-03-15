package com.proyectojm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOServicio;
import com.proyectojm.app.dto.ServicioDto;
import com.proyectojm.app.entities.ServicioEntity;
import com.proyectojm.app.service.IServiceServicio;

@Service
public class ServicioServiceImpl implements IServiceServicio {

    @Autowired
    private IDAOServicio servicioDao;

    @Override
    public void guardarServicio(ServicioDto servicio) {
        // Implementa la lógica para guardar un servicio
    }

    @Override
    public void modificarServicio(ServicioDto servicio) {
        // Implementa la lógica para modificar un servicio
    }

    @Override
    public void eliminarServicio(Integer id) {
        // Implementa la lógica para eliminar un servicio por su ID
    }

    @Override
    public List<ServicioDto> recuperarTodosLosServicios() {
        // Implementa la lógica para recuperar todos los servicios
        return null; // Cambia esto para devolver la lista real de servicios
    }

    @Override
    public ServicioDto recuperarUnServicio(Integer id) {
        // Implementa la lógica para recuperar un servicio por su ID
        return null; // Cambia esto para devolver el servicio real
    }
}
