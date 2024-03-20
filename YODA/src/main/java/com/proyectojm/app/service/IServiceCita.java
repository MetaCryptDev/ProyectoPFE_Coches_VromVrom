package com.proyectojm.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.proyectojm.app.dto.CitaDto;

public interface IServiceCita {

    public void guardarCita(CitaDto cita);
    public void modificarCita(CitaDto cita);
    public void eliminarCita(Integer id);
    public List<CitaDto> recuperarTodasLasCitas();
    public CitaDto recuperarUnaCita(Integer id);
	List<LocalTime> recuperarHorasDisponibles(Integer idServicio, LocalDate fecha);

}
