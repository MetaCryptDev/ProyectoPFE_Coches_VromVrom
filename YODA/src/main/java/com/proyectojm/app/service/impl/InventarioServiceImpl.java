package com.proyectojm.app.service.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectojm.app.dao.IDAOInventario;
import com.proyectojm.app.dto.InventarioDto;
import com.proyectojm.app.entities.InventarioEntity;
import com.proyectojm.app.service.IServiceInventario;

@Service
public class InventarioServiceImpl implements IServiceInventario {

    @Autowired
    private IDAOInventario inventarioDao;

    @Override
    @Transactional
    public void guardarPieza(InventarioDto pieza) {
        InventarioEntity piezaEntity = new InventarioEntity();
        try {
            piezaEntity.setIdPieza(pieza.getIdPieza());
            piezaEntity.setCantidad(pieza.getCantidad());
            piezaEntity.setPrecio(pieza.getPrecio());
            piezaEntity.setDescripcion(pieza.getDescripcion());
            piezaEntity.setUrlImagen(pieza.getUrlImagen());

            inventarioDao.save(piezaEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void modificarPieza(InventarioDto pieza) {
        try {
            InventarioEntity piezaEntity = inventarioDao.findById(pieza.getIdPieza()).orElse(null);
            if (piezaEntity != null) {
                piezaEntity.setCantidad(pieza.getCantidad());
                piezaEntity.setPrecio(pieza.getPrecio());
                piezaEntity.setDescripcion(pieza.getDescripcion());
                piezaEntity.setUrlImagen(pieza.getUrlImagen());

                inventarioDao.save(piezaEntity);
            } else {
                System.out.println("La entidad no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminarPieza(Integer id) {
        InventarioEntity entidad = null;
        try {
            entidad = inventarioDao.findById(id).orElse(null);
            if (entidad != null) {
                inventarioDao.delete(entidad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<InventarioDto> recuperarTodasLasPiezas() {
        List<InventarioDto> lstResultado = null;
        Iterable<InventarioEntity> lstEntidades = null;
        try {
            lstResultado = new ArrayList<>();
            lstEntidades = inventarioDao.findAll();
            for (Iterator<InventarioEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
                InventarioEntity entity = iterator.next();
                InventarioDto actual = new InventarioDto();
                actual.setIdPieza(entity.getIdPieza());
                actual.setCantidad(entity.getCantidad());
                actual.setPrecio(entity.getPrecio());
                actual.setDescripcion(entity.getDescripcion());
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
    public InventarioDto recuperarUnaPieza(Integer id) {
        InventarioDto actual = new InventarioDto();
        InventarioEntity entity = null;
        try {
            entity = inventarioDao.findById(id).orElse(null);
            if (entity != null) {
                actual.setIdPieza(entity.getIdPieza());
                actual.setCantidad(entity.getCantidad());
                actual.setPrecio(entity.getPrecio());
                actual.setDescripcion(entity.getDescripcion());
                actual.setUrlImagen(entity.getUrlImagen());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actual;
    }

	@Override
	@Transactional
	public List<InventarioDto> buscador(String descripcion) {
		List<InventarioEntity> listaEncontrados = inventarioDao.findByDescripcionContaining(descripcion);
		
		List<InventarioDto> lstResultado = null;
        Iterable<InventarioEntity> lstEntidades = listaEncontrados;
        try {
            lstResultado = new ArrayList<>();
            for (Iterator<InventarioEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
                InventarioEntity entity = iterator.next();
                InventarioDto actual = new InventarioDto();
                actual.setIdPieza(entity.getIdPieza());
                actual.setCantidad(entity.getCantidad());
                actual.setPrecio(entity.getPrecio());
                actual.setDescripcion(entity.getDescripcion());
                actual.setUrlImagen(entity.getUrlImagen());
                lstResultado.add(actual);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstResultado;
	}
}
