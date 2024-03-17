package com.proyectojm.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectojm.app.dao.IDAOContacto;
import com.proyectojm.app.dto.ContactoDto;
import com.proyectojm.app.entities.ContactoEntity;
import com.proyectojm.app.service.IServiceContacto;

@Service
public class ContactoServiceImpl implements IServiceContacto {
	
	@Autowired IDAOContacto contactoDao;
	
	@Override
	@Transactional
	public void guardarContacto(ContactoDto contacto) {
		ContactoEntity contactoEntty=  new ContactoEntity();
		try {
			contactoEntty.setId(contacto.getId());
			contactoEntty.setMail(contacto.getMail());
			contactoEntty.setMensaje(contacto.getMensaje());
			contactoEntty.setMotivo(contacto.getMotivo());
			contactoEntty.setNombre(contacto.getNombre());
			contactoDao.save(contactoEntty);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public void modificarContacto(ContactoDto contacto) {
		try {
        	ContactoEntity contactoEntty = contactoDao.findById(contacto.getId()).orElse(null);

            if (contactoEntty != null) {
            	contactoEntty.setMail(contacto.getMail());
    			contactoEntty.setMensaje(contacto.getMensaje());
    			contactoEntty.setMotivo(contacto.getMotivo());
    			contactoEntty.setNombre(contacto.getNombre());
    			
    			contactoDao.save(contactoEntty);
            } else {
                System.out.println("La entidad no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	@Override
	@Transactional
	public List<ContactoDto> recuperarTodosLosContactos() {
			List<ContactoDto> lstResultado = null;
	        Iterable<ContactoEntity> lstEntidades = null;

	        try {
	            lstResultado = new ArrayList<>();
	            lstEntidades = contactoDao.findAll();

	            for (Iterator<ContactoEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
	            	ContactoEntity entity = iterator.next();
	            	ContactoDto actual = new ContactoDto();
	            	
	            	actual.setId(entity.getId());
	            	actual.setMail(entity.getMail());
	            	actual.setMensaje(entity.getMensaje());
	            	actual.setMotivo(entity.getMotivo());
	            	actual.setNombre(entity.getNombre());
	            	
	                lstResultado.add(actual);
	            }

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        return lstResultado;
	}
	
	@Override
	@Transactional
	public ContactoDto recuperarUnContacto(Integer id) {
		ContactoDto actual = new ContactoDto();
		 ContactoEntity entity = null;
      try {
          entity = contactoDao.findById(id).orElse(null);
          if (entity != null) {
        	  actual.setId(entity.getId());
	          	actual.setMail(entity.getMail());
	          	actual.setMensaje(entity.getMensaje());
	          	actual.setMotivo(entity.getMotivo());
	          	actual.setNombre(entity.getNombre());
          }
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
	        return actual;
	}
}
