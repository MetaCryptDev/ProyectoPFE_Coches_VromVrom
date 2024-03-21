package com.proyectojm.app.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.controllers.CorreoController;
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
	
	@Autowired
	private CorreoController correos;
		

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

			// SALIDA cita.getEntrada().plusHours()

			switch (citaEntty.getServicioId()) {
			case 1, 2:
				citaEntty.setSalida(citaEntty.getEntrada().plusHours(2));
				if (citaEntty.getSalida().getHour() > 13) {
					citaEntty.setSalida(citaEntty.getSalida().plusHours(2));
				}
				break;

			case 3:
				citaEntty.setSalida(citaEntty.getEntrada().plusHours(1));
				if (citaEntty.getSalida().getHour() > 13) {
					citaEntty.setSalida(citaEntty.getSalida().plusHours(2));
				}
				break;

			case 4:
				citaEntty.setSalida(citaEntty.getEntrada().plusHours(4));
				if (citaEntty.getSalida().getHour() > 13) {
					citaEntty.setSalida(citaEntty.getSalida().plusHours(2));
				}
				break;

			default:
				citaEntty.setSalida(citaEntty.getEntrada().plusHours(0));
				break;
			}

			// ID VEHICULO SUSTITUCION
			citaEntty.setVehiculoSustitucionMatricula(
					cita.getIdVehiculoSustitucion() != null ? cita.getIdVehiculoSustitucion() : null);

			// DESCRIPCION AVERIA
			citaEntty.setDescripcionAveria(cita.getDescripcionAveria() != null ? cita.getDescripcionAveria() : null);

			citaDao.save(citaEntty);
			correos.enviarCorreo(citaEntty);

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
			citaEntty.setVehiculoSustitucionMatricula(
					cita.getIdVehiculoSustitucion() != null ? cita.getIdVehiculoSustitucion() : null);

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
				actual.setIdVehiculoSustitucion(
						entity.getVehiculoSustitucionMatricula() != null ? entity.getVehiculoSustitucionMatricula()
								: null);

				// DESCRIPCION AVERIA
				actual.setDescripcionAveria(
						entity.getDescripcionAveria() != null ? entity.getDescripcionAveria() : null);

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
				actual.setIdVehiculoSustitucion(
						entity.getVehiculoSustitucionMatricula() != null ? entity.getVehiculoSustitucionMatricula()
								: null);

				// DESCRIPCION AVERIA
				actual.setDescripcionAveria(
						entity.getDescripcionAveria() != null ? entity.getDescripcionAveria() : null);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return actual;
	}

	@Override
	public List<LocalTime> recuperarHorasDisponibles(Integer idServicio, LocalDate fecha) {

		int duracionServicio;
		switch (idServicio) {
		case 1, 2:

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
		
		List<LocalTime> horasPosibles = new ArrayList<>();
		LocalTime horaFinal = LocalTime.of(19, 0);
		LocalTime horaInicio = LocalTime.of(9, 0);
		LocalTime horaDescanso = LocalTime.of(14, 0);

		while (horaInicio.plusHours(duracionServicio).isBefore(horaFinal)
				|| horaInicio.plusHours(duracionServicio).equals(horaFinal)) {
			if (!horaInicio.equals(horaDescanso)) {
				horasPosibles.add(horaInicio);
			}
			horaInicio = horaInicio.plusHours(1);
		}

		
		List<CitaEntity> citasDelDia = citaDao.findByEntradaBetween(fecha.atStartOfDay(),
				fecha.plusDays(1).atStartOfDay());

	
		List<LocalTime> horasDisponibles = new ArrayList<>(horasPosibles);

		
		for (LocalTime hora : horasPosibles) {
			int citasEnHora = 0;
			LocalDateTime inicioComparacion = LocalDateTime.of(fecha, hora);
			LocalDateTime finComparacion = inicioComparacion.plusHours(duracionServicio);

			for (CitaEntity cita : citasDelDia) {
				
				if (cita.getEntrada().isBefore(finComparacion) && cita.getSalida().isAfter(inicioComparacion)) {
					citasEnHora++;
					System.out.println(citasEnHora);
				}
			}

			
			if (citasEnHora >= 3) {
				horasDisponibles.remove(hora);

			}
		}

		return horasDisponibles;
	}
}
