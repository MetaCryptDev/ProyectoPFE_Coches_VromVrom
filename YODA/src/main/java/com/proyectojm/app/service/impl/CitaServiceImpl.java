package com.proyectojm.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOCita;
import com.proyectojm.app.dto.CitaDto;
import com.proyectojm.app.entities.CitaEntity;
import com.proyectojm.app.service.IServiceCita;

@Service
public class CitaServiceImpl implements IServiceCita {

    @Autowired
    private IDAOCita citaDao;

    @Override
    public void guardarCita(CitaDto cita) {
    	CitaEntity citaEntty = new CitaEntity();
		try {

			// ID CITA
			citaEntty.setIdCita(cita.getIdCita() != null ? cita.getIdCita() : null);

			// ENTRADA
			citaEntty.setEntrada(cita.getEntrada() != null ? cita.getEntrada() : null);

			// ID USUARIO
			citaEntty.setUsuarioId(cita.getIdUsuario() != null ? cita.getIdUsuario() : null);

			// ID VEHICULO
			citaEntty.setVehiculoMatricula(cita.getIdVehiculo() != null ? cita.getIdVehiculo() : null);

			// ID SERVICIO
			citaEntty.setServicioId(cita.getIdServicio() != null ? cita.getIdServicio() : null);

			// ID VEHICULO SUSTITUCION
			citaEntty.setVehiculoSustitucionMatricula(cita.getIdVehiculoSustitucion() != null ? cita.getIdVehiculoSustitucion() : null);

			// DESCRIPCION AVERIA
			citaEntty.setDescripcionAveria(cita.getDescripcionAveria() != null ? cita.getDescripcionAveria() : null);

			citaDao.save(citaEntty);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public void modificarCita(CitaDto cita) {
    	CitaEntity citaEntty = new CitaEntity();
    	
		try {

			// ID CITA
			citaEntty.setIdCita(cita.getIdCita() != null ? cita.getIdCita() : null);

			// ENTRADA
			citaEntty.setEntrada(cita.getEntrada() != null ? cita.getEntrada() : null);

			// ID USUARIO
			citaEntty.setUsuarioId(cita.getIdUsuario() != null ? cita.getIdUsuario() : null);

			// ID VEHICULO
			citaEntty.setVehiculoMatricula(cita.getIdVehiculo() != null ? cita.getIdVehiculo() : null);

			// ID SERVICIO
			citaEntty.setServicioId(cita.getIdServicio() != null ? cita.getIdServicio() : null);

			// ID VEHICULO SUSTITUCION
			citaEntty.setVehiculoSustitucionMatricula(cita.getIdVehiculoSustitucion() != null ? cita.getIdVehiculoSustitucion() : null);

			// DESCRIPCION AVERIA
			citaEntty.setDescripcionAveria(cita.getDescripcionAveria() != null ? cita.getDescripcionAveria() : null);

			
			citaDao.save(citaEntty);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    @Override
    public void eliminarCita(Integer id) {
    	CitaEntity cita = null;
        try {
            cita = citaDao.findById(id).orElse(null);
            if (cita != null) {
            	citaDao.delete(cita);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<CitaDto> recuperarTodasLasCitas() {
    	List<CitaDto> lstResultado = null;
        Iterable<CitaEntity> lstEntidades = null;

        try {
            lstResultado = new ArrayList<>();
            lstEntidades = citaDao.findAll();

            for (Iterator<CitaEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
            	CitaEntity entity = iterator.next();
            	CitaDto actual = new CitaDto();
            	
            	// ID CITA
            	actual.setIdCita(entity.getIdCita() != null ? entity.getIdCita() : null);

            	// ENTRADA
            	actual.setEntrada(entity.getEntrada() != null ? entity.getEntrada() : null);

            	// ID USUARIO
            	actual.setIdUsuario(entity.getUsuarioId() != null ? entity.getUsuarioId() : null);

            	// ID VEHICULO
            	actual.setIdVehiculo(entity.getVehiculoMatricula() != null ? entity.getVehiculoMatricula() : null);

            	// ID SERVICIO
            	actual.setIdServicio(entity.getServicioId() != null ? entity.getServicioId() : null);

            	// ID VEHICULO SUSTITUCION
            	actual.setIdVehiculoSustitucion(entity.getVehiculoSustitucionMatricula() != null ? entity.getVehiculoSustitucionMatricula() : null);

            	// DESCRIPCION AVERIA
            	actual.setDescripcionAveria(entity.getDescripcionAveria() != null ? entity.getDescripcionAveria() : null);

                lstResultado.add(actual);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lstResultado;
    }

    @Override
    public CitaDto recuperarUnaCita(Integer id) {
    	CitaDto actual = new CitaDto();
    	CitaEntity entity = null;
  
        try {
            entity = citaDao.findById(id).orElse(null);
            if (entity != null) {
            	// ID CITA
            	actual.setIdCita(entity.getIdCita() != null ? entity.getIdCita() : null);

            	// ENTRADA
            	actual.setEntrada(entity.getEntrada() != null ? entity.getEntrada() : null);

            	// ID USUARIO
            	actual.setIdUsuario(entity.getUsuarioId() != null ? entity.getUsuarioId() : null);

            	// ID VEHICULO
            	actual.setIdVehiculo(entity.getVehiculoMatricula() != null ? entity.getVehiculoMatricula() : null);

            	// ID SERVICIO
            	actual.setIdServicio(entity.getServicioId() != null ? entity.getServicioId() : null);

            	// ID VEHICULO SUSTITUCION
            	actual.setIdVehiculoSustitucion(entity.getVehiculoSustitucionMatricula() != null ? entity.getVehiculoSustitucionMatricula() : null);

            	// DESCRIPCION AVERIA
            	actual.setDescripcionAveria(entity.getDescripcionAveria() != null ? entity.getDescripcionAveria() : null);

                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actual;
    }
}
