package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.ContactoDto;
import com.proyectojm.app.dto.UsuarioDto;

public interface IServiceContacto {

	
	public void guardarContacto(ContactoDto contacto);
	public void modificarContacto(ContactoDto contacto);
	public List<UsuarioDto> recuperarTodosLosContactos();
	public UsuarioDto recuperarUnContacto(Integer id);
	
}
