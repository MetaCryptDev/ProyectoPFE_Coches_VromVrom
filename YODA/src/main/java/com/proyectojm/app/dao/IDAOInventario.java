package com.proyectojm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.InventarioEntity;

public interface IDAOInventario extends CrudRepository<InventarioEntity, Integer> {

}
