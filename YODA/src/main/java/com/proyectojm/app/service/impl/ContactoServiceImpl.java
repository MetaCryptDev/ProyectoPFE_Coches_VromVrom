package com.proyectojm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOContacto;
import com.proyectojm.app.dto.ContactoDto;
import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.entities.ContactoEntity;
import com.proyectojm.app.service.IServiceContacto;

@Service
public class ContactoServiceImpl implements IServiceContacto {
	
	@Autowired IDAOContacto contactoDao;
	
	public void guardarContacto(ContactoDto contacto) {
		ContactoEntity contactoEntty=  new ContactoEntity();
		try {
			contactoEntty.setMail(contacto.getMail());
			contactoEntty.setMensaje(contacto.getMensaje());
			contactoEntty.setMotivo(contacto.getMotivo());
			contactoEntty.setNombre(contacto.getNombre());
			contactoDao.save(contactoEntty);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public void modificarContacto(ContactoDto contacto) {
		
	}
	public List<UsuarioDto> recuperarTodosLosContactos() {
		
		return null;
		
	}
	public UsuarioDto recuperarUnContacto(Integer id) {
		
		return null;
	}
}
