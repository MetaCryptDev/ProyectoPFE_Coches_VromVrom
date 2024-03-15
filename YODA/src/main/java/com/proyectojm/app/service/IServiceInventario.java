package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.InventarioDto;

public interface IServiceInventario {

    public void guardarInventario(InventarioDto inventario);
    public void modificarInventario(InventarioDto inventario);
    public void eliminarInventario(Integer id);
    public List<InventarioDto> recuperarTodosLosInventarios();
    public InventarioDto recuperarUnInventario(Integer id);

}
