package com.proyectojm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOInventario;
import com.proyectojm.app.dto.InventarioDto;
import com.proyectojm.app.service.IServiceInventario;

@Service
public class InventarioServiceImpl implements IServiceInventario {

    @Autowired
    private IDAOInventario inventarioDao;

    @Override
    public void guardarInventario(InventarioDto inventario) {
        // Aquí implementa la lógica para guardar un inventario
    }

    @Override
    public void modificarInventario(InventarioDto inventario) {
        // Aquí implementa la lógica para modificar un inventario
    }

    @Override
    public void eliminarInventario(Integer id) {
        // Aquí implementa la lógica para eliminar un inventario por su ID
    }

    @Override
    public List<InventarioDto> recuperarTodosLosInventarios() {
        // Aquí implementa la lógica para recuperar todos los inventarios
        return null; // Cambia esto para devolver la lista real de inventarios
    }

    @Override
    public InventarioDto recuperarUnInventario(Integer id) {
        // Aquí implementa la lógica para recuperar un inventario por su ID
        return null; // Cambia esto para devolver el inventario real
    }
}
