package com.proyectojm.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectojm.app.dto.ContactoDto;
import com.proyectojm.app.service.IServiceContacto;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/contacto")
public class ContactoController {
	
	@Autowired
	private IServiceContacto contactoService;
	@Autowired
	private CorreoController correos;
	
	@GetMapping(value = "/verTodos")
	
	
	@PostMapping(value = "/insertar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void insertar(@RequestBody ContactoDto contacto) {
		try {
		
			contactoService.guardarContacto(contacto);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
