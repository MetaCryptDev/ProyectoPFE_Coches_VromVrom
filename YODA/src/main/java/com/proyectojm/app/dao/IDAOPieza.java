package com.proyectojm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.ContactoEntity;
import com.proyectojm.app.entities.PiezaEntity;

public interface IDAOPieza extends CrudRepository<PiezaEntity, Integer> {

}
