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
	

	@Override
	public void guardarUsuario(UsuarioDto usuario) {
		UsuarioEntity usuarioEntty=  new UsuarioEntity();
		try {
			usuarioEntty.setIdUsuario(usuario.getIdUsuario());
			usuarioEntty.setNombre(usuario.getNombre());
			usuarioEntty.setApellido(usuario.getApellido());
			usuarioEntty.setMail(usuario.getMail());
			usuarioEntty.setTelefono(usuario.getTelefono());
			usuarioEntty.setPasswd(usuario.getPasswd());
			
			System.out.println("usuario "+usuario.getIdUsuario());
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
