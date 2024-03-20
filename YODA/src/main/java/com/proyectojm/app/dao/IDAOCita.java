package com.proyectojm.app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.CitaEntity;

public interface IDAOCita extends CrudRepository<CitaEntity, Integer> {

	List<CitaEntity> findByEntradaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
