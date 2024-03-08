package com.proyectojm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.UsuarioEntity;

public interface IDAOUsuario extends CrudRepository<UsuarioEntity, Integer> {

}
