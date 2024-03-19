package com.proyectojm.app.service.impl;

import com.proyectojm.app.dao.IDAOVehiculo;
import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.dto.VehiculoDto;
import com.proyectojm.app.entities.VehiculoEntity;
import com.proyectojm.app.service.IServiceVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IServiceVehiculo {

    @Autowired
    private IDAOVehiculo vehiculoDao;

    @Override
    @Transactional
    public void guardarVehiculo(VehiculoDto vehiculo) {
        try {
            VehiculoEntity vehiculoEntity = new VehiculoEntity();
            vehiculoEntity.setMatricula(vehiculo.getMatricula());
            vehiculoEntity.setModelo(vehiculo.getModelo());
            vehiculoEntity.setMarca(vehiculo.getMarca());
            vehiculoEntity.setIdUsuario(vehiculo.getIdUsuario());

            vehiculoDao.save(vehiculoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void modificarVehiculo(VehiculoDto vehiculo) {
        try {
            VehiculoEntity vehiculoEntity = vehiculoDao.findById(vehiculo.getMatricula()).orElse(null);
            if (vehiculoEntity != null) {
                vehiculoEntity.setModelo(vehiculo.getModelo());
                vehiculoEntity.setMarca(vehiculo.getMarca());
                vehiculoEntity.setIdUsuario(vehiculo.getIdUsuario());

                vehiculoDao.save(vehiculoEntity);
            } else {
                System.out.println("La entidad no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminarVehiculo(String matricula) {
        try {
            vehiculoDao.deleteById(matricula);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<VehiculoDto> recuperarTodosLosVehiculos() {
        List<VehiculoDto> lstResultado = new ArrayList<>();
        try {
            Iterable<VehiculoEntity> iterableEntidades = vehiculoDao.findAll();
            for (VehiculoEntity entity : iterableEntidades) {
                VehiculoDto actual = new VehiculoDto();
                actual.setMatricula(entity.getMatricula());
                actual.setModelo(entity.getModelo());
                actual.setMarca(entity.getMarca());
                actual.setIdUsuario(entity.getIdUsuario());
                lstResultado.add(actual);
            }
        } catch (Exception e) {
            System.out.println("Error al recuperar los vehículos: " + e.getMessage());
        }
        return lstResultado;
    }

    @Override
    @Transactional
    public VehiculoDto recuperarUnVehiculo(String matricula) {
        VehiculoDto actual = new VehiculoDto();
        try {
            VehiculoEntity entity = vehiculoDao.findById(matricula).orElse(null);
            if (entity != null) {
                actual.setMatricula(entity.getMatricula());
                actual.setModelo(entity.getModelo());
                actual.setMarca(entity.getMarca());
                actual.setIdUsuario(entity.getIdUsuario()); // Obtener solo el ID del usuario
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actual;
    }
}
