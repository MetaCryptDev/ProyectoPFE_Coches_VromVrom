package com.proyectojm.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.service.IServiceUsuario;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/productos")
public class UsuarioRestController {
	
	@Autowired
	private IServiceUsuario usuarioService;
	
	@GetMapping(value = "/verTodos")
	
	public List<UsuarioDto> verTodos() {
		List<UsuarioDto> lstUsuarios = null;
		
		try {
			lstUsuarios = usuarioService.recuperarTodosLosUsuarios();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lstUsuarios;
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		try {
			
			usuarioService.eliminarUsuario(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@GetMapping(value = "/recuperarUnProducto/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public UsuarioDto recuperarUnProducto(@PathVariable Integer id) {
		UsuarioDto usuario = null;
		
		try {
			usuario = usuarioService.recuperarUnUsuario(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return usuario;
	}
	
	
	
	
	@PostMapping(value = "/insertar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void insertar(@RequestBody UsuarioDto usuario) {
		try {
			usuarioService.guardarUsuario(usuario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
