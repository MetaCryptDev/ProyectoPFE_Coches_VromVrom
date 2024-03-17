package com.proyectojm.app.service.impl;

import com.proyectojm.app.dao.IDAOVehiculo;
import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.dto.VehiculoDto;
import com.proyectojm.app.entities.UsuarioEntity;
import com.proyectojm.app.entities.VehiculoEntity;
import com.proyectojm.app.service.IServiceVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IServiceVehiculo {

    @Autowired
    private IDAOVehiculo vehiculoDao;

    @Override
    @Transactional
    public void guardarVehiculo(VehiculoDto vehiculo) {
        VehiculoEntity vehiculoEntity = new VehiculoEntity();
        UsuarioEntity user = null;
        
        try {
            vehiculoEntity.setMatricula(vehiculo.getMatricula());
            vehiculoEntity.setModelo(vehiculo.getModelo());
            vehiculoEntity.setMarca(vehiculo.getMarca());
           
            if(vehiculo.getUsuario() != null) {
				//USUARIO
				user = new UsuarioEntity();
				user.setIdUsuario(vehiculo.getUsuario().getIdUsuario());
				user.setNombre(vehiculo.getUsuario().getNombre());
				user.setApellido(vehiculo.getUsuario().getApellido());
				user.setTelefono(vehiculo.getUsuario().getTelefono());
				user.setMail(vehiculo.getUsuario().getMail());
				user.setPasswd(vehiculo.getUsuario().getPasswd());
				
				vehiculoEntity.setUsuario(user);
			}

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
            UsuarioEntity user = null;
            if (vehiculoEntity != null) {
                vehiculoEntity.setModelo(vehiculo.getModelo());
                vehiculoEntity.setMarca(vehiculo.getMarca());
                if(vehiculo.getUsuario() != null) {
    				//USUARIO
    				user = new UsuarioEntity();
    				user.setIdUsuario(vehiculo.getUsuario().getIdUsuario());
    				user.setNombre(vehiculo.getUsuario().getNombre());
    				user.setApellido(vehiculo.getUsuario().getApellido());
    				user.setTelefono(vehiculo.getUsuario().getTelefono());
    				user.setMail(vehiculo.getUsuario().getMail());
    				user.setPasswd(vehiculo.getUsuario().getPasswd());
    				
    				vehiculoEntity.setUsuario(user);
    			}

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
        VehiculoEntity entidad = null;
        try {
            entidad = vehiculoDao.findById(matricula).orElse(null);
            if (entidad != null) {
                vehiculoDao.delete(entidad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<VehiculoDto> recuperarTodosLosVehiculos() {
        List<VehiculoDto> lstResultado = null;
        Iterable<VehiculoEntity> lstEntidades = null;
        UsuarioDto user = null;
        try {
            lstResultado = new ArrayList<>();
            lstEntidades = vehiculoDao.findAll();
            for (Iterator<VehiculoEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
                VehiculoEntity entity = iterator.next();
                VehiculoDto actual = new VehiculoDto();
                actual.setMatricula(entity.getMatricula());
                actual.setModelo(entity.getModelo());
                actual.setMarca(entity.getMarca());
                if(entity.getUsuario() != null) {
    				//USUARIO
    				user = new UsuarioDto();
    				user.setIdUsuario(entity.getUsuario().getIdUsuario());
    				user.setNombre(entity.getUsuario().getNombre());
    				user.setApellido(entity.getUsuario().getApellido());
    				user.setTelefono(entity.getUsuario().getTelefono());
    				user.setMail(entity.getUsuario().getMail());
    				user.setPasswd(entity.getUsuario().getPasswd());
    				
    				actual.setUsuario(user);
    			}
                lstResultado.add(actual);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstResultado;
    }

    @Override
    @Transactional
    public VehiculoDto recuperarUnVehiculo(String matricula) {
        VehiculoDto actual = new VehiculoDto();
        VehiculoEntity entity = null;
        UsuarioDto user = null;
        try {
            entity = vehiculoDao.findById(matricula).orElse(null);
            if (entity != null) {
                actual.setMatricula(entity.getMatricula());
                actual.setModelo(entity.getModelo());
                actual.setMarca(entity.getMarca());
                if(entity.getUsuario() != null) {
    				//USUARIO
    				user = new UsuarioDto();
    				user.setIdUsuario(entity.getUsuario().getIdUsuario());
    				user.setNombre(entity.getUsuario().getNombre());
    				user.setApellido(entity.getUsuario().getApellido());
    				user.setTelefono(entity.getUsuario().getTelefono());
    				user.setMail(entity.getUsuario().getMail());
    				user.setPasswd(entity.getUsuario().getPasswd());
    				
    				actual.setUsuario(user);
    			}
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actual;
    }
}
