package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.ServicioDto;

public interface IServiceServicio {

    public void guardarServicio(ServicioDto servicio);
    public void modificarServicio(ServicioDto servicio);
    public void eliminarServicio(Integer id);
    public List<ServicioDto> recuperarTodosLosServicios();
    public ServicioDto recuperarUnServicio(Integer id);

}
