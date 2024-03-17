package com.proyectojm.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectojm.app.dao.IDAOUsuario;
import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.entities.UsuarioEntity;
import com.proyectojm.app.service.IServiceUsuario;

@Service
public class UsuarioServiceImpl implements IServiceUsuario {
	
	@Autowired IDAOUsuario usuarioDao;
	
	
	public boolean login(String username, String password) {
        boolean isLogged = false;
        List<UsuarioDto> lstUsuarios = this.recuperarTodosLosUsuarios();
        UsuarioDto usuario = lstUsuarios.stream().filter(u -> u.getNombre().equals(username) && u.getPasswd().equals(password)).findFirst().orElse(null);

        if(usuario != null) {
            isLogged = true;
        }

        return isLogged;
    }

	@Override
	public void guardarUsuario(UsuarioDto usuario) {
		UsuarioEntity usuarioEntty=  new UsuarioEntity();
		try {
			System.out.println("getIdUsuario "+usuario.getIdUsuario());
			usuarioEntty.setIdUsuario(usuario.getIdUsuario());
			System.out.println("getNombre "+usuario.getNombre());
			usuarioEntty.setNombre(usuario.getNombre());
			System.out.println("getApellido "+usuario.getApellido());
			usuarioEntty.setApellido(usuario.getApellido());
			System.out.println("getMail "+usuario.getMail());
			usuarioEntty.setMail(usuario.getMail());
			System.out.println("getTelefono "+usuario.getTelefono());
			usuarioEntty.setTelefono(usuario.getTelefono());
			System.out.println("getPasswd "+usuario.getPasswd());
			usuarioEntty.setPasswd(usuario.getPasswd());
			
			
			usuarioDao.save(usuarioEntty);
			System.out.println("hecho");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public void modificarUsuario(UsuarioDto usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDto> recuperarTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDto recuperarUnUsuario(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
