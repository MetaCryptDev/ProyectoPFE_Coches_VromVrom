package com.proyectojm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.ServicioEntity;

public interface IDAOServicio extends CrudRepository<ServicioEntity, Integer> {

}
