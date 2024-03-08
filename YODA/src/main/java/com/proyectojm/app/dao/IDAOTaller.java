package com.proyectojm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.TallerEntity;

public interface IDAOTaller extends CrudRepository<TallerEntity, Integer> {

}
