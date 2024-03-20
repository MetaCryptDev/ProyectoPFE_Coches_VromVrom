package com.proyectojm.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.InventarioEntity;

public interface IDAOInventario extends CrudRepository<InventarioEntity, Integer> {

	List<InventarioEntity> findByDescripcionContaining(String descripcion);
}
