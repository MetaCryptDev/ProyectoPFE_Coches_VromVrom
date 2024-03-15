package com.proyectojm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.VehiculoEntity;

public interface IDAOVehiculo extends CrudRepository<VehiculoEntity, Integer> {
}
