package com.proyectojm.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectojm.app.dao.IDAOVehiculoSustitucion;
import com.proyectojm.app.dto.VehiculoSustitucionDto;
import com.proyectojm.app.entities.VehiculoSustitucionEntity;
import com.proyectojm.app.service.IServiceVehiculoSustitucion;

@Service
public class VehiculoSustitucionServiceImpl implements IServiceVehiculoSustitucion {

    @Autowired
    private IDAOVehiculoSustitucion vehiculoSustitucionDao;

    @Override
    @Transactional
    public void guardarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion) {
        VehiculoSustitucionEntity vehiculoSustitucionEntity = new VehiculoSustitucionEntity();
        try {
            vehiculoSustitucionEntity.setMatricula(vehiculoSustitucion.getMatricula());
            vehiculoSustitucionEntity.setModelo(vehiculoSustitucion.getModelo());
            vehiculoSustitucionEntity.setMarca(vehiculoSustitucion.getMarca());
            vehiculoSustitucionEntity.setPrecioPorDia(vehiculoSustitucion.getPrecioPorDia());
            vehiculoSustitucionEntity.setUrlImagen(vehiculoSustitucion.getUrlImagen());

            vehiculoSustitucionDao.save(vehiculoSustitucionEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void modificarVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion) {
        try {
            VehiculoSustitucionEntity vehiculoSustitucionEntity = vehiculoSustitucionDao.findById(vehiculoSustitucion.getMatricula()).orElse(null);
            if (vehiculoSustitucionEntity != null) {
                vehiculoSustitucionEntity.setModelo(vehiculoSustitucion.getModelo());
                vehiculoSustitucionEntity.setMarca(vehiculoSustitucion.getMarca());
                vehiculoSustitucionEntity.setPrecioPorDia(vehiculoSustitucion.getPrecioPorDia());
                vehiculoSustitucionEntity.setUrlImagen(vehiculoSustitucion.getUrlImagen());

                vehiculoSustitucionDao.save(vehiculoSustitucionEntity);
            } else {
                System.out.println("La entidad no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminarVehiculoSustitucion(String matricula) {
        VehiculoSustitucionEntity entidad = null;
        try {
            entidad = vehiculoSustitucionDao.findById(matricula).orElse(null);
            if (entidad != null) {
                vehiculoSustitucionDao.delete(entidad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<VehiculoSustitucionDto> recuperarTodosLosVehiculosSustitucion() {
        List<VehiculoSustitucionDto> lstResultado = null;
        Iterable<VehiculoSustitucionEntity> lstEntidades = null;
        try {
            lstResultado = new ArrayList<>();
            lstEntidades = vehiculoSustitucionDao.findAll();
            for (Iterator<VehiculoSustitucionEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
                VehiculoSustitucionEntity entity = iterator.next();
                VehiculoSustitucionDto actual = new VehiculoSustitucionDto();
                actual.setMatricula(entity.getMatricula());
                actual.setModelo(entity.getModelo());
                actual.setMarca(entity.getMarca());
                actual.setPrecioPorDia(entity.getPrecioPorDia());
                actual.setUrlImagen(entity.getUrlImagen());
                lstResultado.add(actual);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstResultado;
    }

    @Override
    @Transactional
    public VehiculoSustitucionDto recuperarUnVehiculoSustitucion(String matricula) {
        VehiculoSustitucionDto actual = new VehiculoSustitucionDto();
        VehiculoSustitucionEntity entity = null;
        try {
            entity = vehiculoSustitucionDao.findById(matricula).orElse(null);
            if (entity != null) {
                actual.setMatricula(entity.getMatricula());
                actual.setModelo(entity.getModelo());
                actual.setMarca(entity.getMarca());
                actual.setPrecioPorDia(entity.getPrecioPorDia());
                actual.setUrlImagen(entity.getUrlImagen());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actual;
    }
}
