package com.proyectojm.app.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectojm.app.dao.IDAOUsuario;
import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.entities.UsuarioEntity;
import com.proyectojm.app.service.IServiceUsuario;

@Service
public class UsuarioServiceImpl implements IServiceUsuario {
	
	@Autowired IDAOUsuario usuarioDao;
	
	
	public UsuarioDto login(String username, String password) {
        boolean isLogged = false;
        List<UsuarioDto> lstUsuarios = this.recuperarTodosLosUsuarios();
        UsuarioDto usuario = lstUsuarios.stream().filter(u -> u.getNombre().equals(username) && u.getPasswd().equals(password)).findFirst().orElse(null);

        if(usuario != null) {
            isLogged = true;
        }

        return usuario;
    }

	@Override
	@Transactional
	public void guardarUsuario(UsuarioDto usuario) {
		UsuarioEntity usuarioEntty = new UsuarioEntity();
		try {

			usuarioEntty.setIdUsuario(usuario.getIdUsuario());
			usuarioEntty.setNombre(usuario.getNombre());
			usuarioEntty.setApellido(usuario.getApellido());
			usuarioEntty.setMail(usuario.getMail());
			usuarioEntty.setTelefono(usuario.getTelefono());
			usuarioEntty.setPasswd(usuario.getPasswd());

			usuarioDao.save(usuarioEntty);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

	@Override
	@Transactional
	public void modificarUsuario(UsuarioDto usuario) {
        try {
        	UsuarioEntity usuarioEntty = usuarioDao.findById(usuario.getIdUsuario()).orElse(null);

            if (usuarioEntty != null) {
            	usuarioEntty.setNombre(usuario.getNombre());
    			usuarioEntty.setApellido(usuario.getApellido());
    			usuarioEntty.setMail(usuario.getMail());
    			usuarioEntty.setTelefono(usuario.getTelefono());
    			usuarioEntty.setPasswd(usuario.getPasswd());

    			usuarioDao.save(usuarioEntty);
            } else {
                System.out.println("La entidad no existe.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	@Override
	@Transactional
	public void eliminarUsuario(Integer id) {
		UsuarioEntity entidad = null;
        try {
            entidad = usuarioDao.findById(id).orElse(null);
            if (entidad != null) {
            	usuarioDao.delete(entidad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

	@Override
	@Transactional
	public List<UsuarioDto> recuperarTodosLosUsuarios() {
		   List<UsuarioDto> lstResultado = null;
	        Iterable<UsuarioEntity> lstEntidades = null;

	        try {
	            lstResultado = new ArrayList<>();
	            lstEntidades = usuarioDao.findAll();

	            for (Iterator<UsuarioEntity> iterator = lstEntidades.iterator(); iterator.hasNext();) {
	            	UsuarioEntity entity = iterator.next();
	            	UsuarioDto actual = new UsuarioDto();
	                actual.setIdUsuario(entity.getIdUsuario());
	                actual.setNombre(entity.getNombre());
	                actual.setApellido(entity.getApellido());
	                actual.setMail(entity.getMail());
	                actual.setTelefono(entity.getTelefono());
	                actual.setPasswd(entity.getPasswd());
	    			
	                lstResultado.add(actual);
	            }

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        return lstResultado;
	}

	@Override
	@Transactional
	public UsuarioDto recuperarUnUsuario(Integer id) {
		UsuarioDto actual = new UsuarioDto();
		 UsuarioEntity entity = null;
       try {
           entity = usuarioDao.findById(id).orElse(null);
           if (entity != null) {
        	   actual.setIdUsuario(entity.getIdUsuario());
               actual.setNombre(entity.getNombre());
               actual.setApellido(entity.getApellido());
               actual.setMail(entity.getMail());
               actual.setTelefono(entity.getTelefono());
               actual.setPasswd(entity.getPasswd());
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

	        return actual;
	}

}
