package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.CitaDto;

public interface IServiceCita {

    public void guardarCita(CitaDto cita);
    public void modificarCita(CitaDto cita);
    public void eliminarCita(Integer id);
    public List<CitaDto> recuperarTodasLasCitas();
    public CitaDto recuperarUnaCita(Integer id);

}
