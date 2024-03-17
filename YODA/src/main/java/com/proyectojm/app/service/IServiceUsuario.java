package com.proyectojm.app.service;

import java.util.List;

import com.proyectojm.app.dto.UsuarioDto;

public interface IServiceUsuario {

	public boolean login(String username, String password);
	public void guardarUsuario(UsuarioDto usuario);
	public void modificarUsuario(UsuarioDto usuario);
	public void eliminarUsuario(Integer id);
	public List<UsuarioDto> recuperarTodosLosUsuarios();
	public UsuarioDto recuperarUnUsuario(Integer id);
	
}
