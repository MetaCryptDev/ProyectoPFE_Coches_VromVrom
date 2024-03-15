package com.proyectojm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOCita;
import com.proyectojm.app.dto.CitaDto;
import com.proyectojm.app.entities.CitaEntity;
import com.proyectojm.app.service.IServiceCita;

@Service
public class CitaServiceImpl implements IServiceCita {

    @Autowired
    private IDAOCita citaDao;

    @Override
    public void guardarCita(CitaDto cita) {
        // Implementa la lógica para guardar una cita
    }

    @Override
    public void modificarCita(CitaDto cita) {
        // Implementa la lógica para modificar una cita
    }

    @Override
    public void eliminarCita(Integer id) {
        // Implementa la lógica para eliminar una cita por su ID
    }

    @Override
    public List<CitaDto> recuperarTodasLasCitas() {
        // Implementa la lógica para recuperar todas las citas
        return null; // Cambia esto para devolver la lista real de citas
    }

    @Override
    public CitaDto recuperarUnaCita(Integer id) {
        // Implementa la lógica para recuperar una cita por su ID
        return null; // Cambia esto para devolver la cita real
    }
}
