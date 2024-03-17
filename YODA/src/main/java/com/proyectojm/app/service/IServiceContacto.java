package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.ContactoDto;

public interface IServiceContacto {

	
	public void guardarContacto(ContactoDto contacto);
	public void modificarContacto(ContactoDto contacto);
	public List<ContactoDto> recuperarTodosLosContactos();
	public ContactoDto recuperarUnContacto(Integer id);
	
}
