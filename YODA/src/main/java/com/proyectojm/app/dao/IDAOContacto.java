package com.proyectojm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyectojm.app.entities.ContactoEntity;

public interface IDAOContacto extends CrudRepository<ContactoEntity, Integer>  {

}
