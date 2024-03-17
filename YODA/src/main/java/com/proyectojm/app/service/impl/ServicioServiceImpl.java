package com.proyectojm.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
        ServicioEntity servicioEntity = new ServicioEntity();
        try {
            servicioEntity.setIdServicio(servicio.getIdServicio());
            servicioEntity.setNombre(servicio.getNombre());
            servicioEntity.setManoDeObra(servicio.getManoDeObra());
            servicioDao.save(servicioEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modificarServicio(ServicioDto servicio) {
        try {
            ServicioEntity servicioEntity = servicioDao.findById(servicio.getIdServicio()).orElse(null);
            if (servicioEntity != null) {
                servicioEntity.setNombre(servicio.getNombre());
                servicioEntity.setManoDeObra(servicio.getManoDeObra());
                servicioDao.save(servicioEntity);
            } else {
                System.out.println("El servicio no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarServicio(Integer id) {
        ServicioEntity entidad = null;
        try {
            entidad = servicioDao.findById(id).orElse(null);
            if (entidad != null) {
                servicioDao.delete(entidad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<ServicioDto> recuperarTodosLosServicios() {
        List<ServicioDto> lstResultado = null;
        Iterable<ServicioEntity> lstEntidades = null;
        try {
            lstResultado = new ArrayList<>();
            lstEntidades = servicioDao.findAll();
            for (Iterator<ServicioEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
                ServicioEntity entity = iterator.next();
                ServicioDto actual = new ServicioDto();
                actual.setIdServicio(entity.getIdServicio());
                actual.setNombre(entity.getNombre());
                actual.setManoDeObra(entity.getManoDeObra());
                lstResultado.add(actual);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstResultado;
    }

    @Override
    public ServicioDto recuperarUnServicio(Integer id) {
        ServicioDto actual = new ServicioDto();
        ServicioEntity entity = null;
        try {
            entity = servicioDao.findById(id).orElse(null);
            if (entity != null) {
                actual.setIdServicio(entity.getIdServicio());
                actual.setNombre(entity.getNombre());
                actual.setManoDeObra(entity.getManoDeObra());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actual;
    }
}
