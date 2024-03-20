package com.proyectojm.app.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOCita;
import com.proyectojm.app.dto.CitaDto;
import com.proyectojm.app.entities.CitaEntity;
import com.proyectojm.app.service.IServiceCita;
import com.proyectojm.app.service.IServiceServicio;

@Service
public class CitaServiceImpl implements IServiceCita {

    @Autowired
    private IDAOCita citaDao;
    
    @Autowired 
    private IServiceServicio servicioServicio;

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
			
			//SALIDA cita.getEntrada().plusHours()
			
			switch(citaEntty.getServicioId()) {
			case 1	,	2:
					citaEntty.setSalida(citaEntty.getEntrada().plusHours(2));
				if(citaEntty.getSalida().getHour()>13) {
					citaEntty.setSalida(citaEntty.getSalida().plusHours(2));
				}
				break;
			
			case 3:
					citaEntty.setSalida(citaEntty.getEntrada().plusHours(1));
					if(citaEntty.getSalida().getHour()>13) {
						citaEntty.setSalida(citaEntty.getSalida().plusHours(2));
					}
				break;
				
			case 4:
					citaEntty.setSalida(citaEntty.getEntrada().plusHours(4));
					if(citaEntty.getSalida().getHour()>13) {
						citaEntty.setSalida(citaEntty.getSalida().plusHours(2));
					}
				break;
			
			default:
				    citaEntty.setSalida(citaEntty.getEntrada().plusHours(0));
				break;
			}
			
			

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
    @Override
    public List<LocalTime> recuperarHorasDisponibles(Integer idServicio, LocalDate fecha) {
        // Definir las horas de inicio posibles para las citas.
        List<LocalTime> horasPosibles = List.of(
            LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0), LocalTime.of(12, 0),
            LocalTime.of(13, 0), LocalTime.of(15, 0), LocalTime.of(16, 0), LocalTime.of(17, 0),
            LocalTime.of(18, 0), LocalTime.of(19, 0)
        );
        
        
        int duracionServicio;
        switch (idServicio) {
            case 1,2:
            
                duracionServicio = 2; 
                break;
            case 3:
                duracionServicio = 1; 
                break;
            case 4:
                duracionServicio = 4; 
                break;
            default:
                duracionServicio = 0; 
                break;
        }

        // Buscar todas las citas para el día especificado.
        List<CitaEntity> citasDelDia = citaDao.findByEntradaBetween(
            fecha.atStartOfDay(),
            fecha.plusDays(1).atStartOfDay()
        );

        // Lista para guardar las horas disponibles.
        List<LocalTime> horasDisponibles = new ArrayList<>(horasPosibles);

        // Verificar disponibilidad de cada hora.
        for (LocalTime hora : horasPosibles) {
            int citasEnHora = 0;
            LocalDateTime inicioComparacion = LocalDateTime.of(fecha, hora);
            LocalDateTime finComparacion = inicioComparacion.plusHours(duracionServicio);
            
            for (CitaEntity cita : citasDelDia) {
                // Comprobamos si la cita actual se superpone con la hora que estamos verificando.
            	if (cita.getEntrada().isBefore(finComparacion) && cita.getSalida().isAfter(inicioComparacion)) {
                    citasEnHora++;
                    System.out.println(citasEnHora);
                }
            }

            // Si hay 3 o más citas en esta hora, no está disponible.
            if (citasEnHora >= 3) {
                horasDisponibles.remove(hora);
                
            }
        }

        return horasDisponibles;
    }
}
