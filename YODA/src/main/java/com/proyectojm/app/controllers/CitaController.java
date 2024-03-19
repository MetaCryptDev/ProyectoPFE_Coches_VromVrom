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

import com.proyectojm.app.dto.CitaDto;
import com.proyectojm.app.dto.ContactoDto;
import com.proyectojm.app.service.IServiceCita;
import com.proyectojm.app.service.IServiceContacto;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/cita")
public class CitaController {
	
	@Autowired
	private IServiceCita citaService;
	
		
	@PostMapping(value = "/insertar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void insertar(@RequestBody CitaDto cita) {
		
		try {
		System.out.println(cita.getIdUsuario());
			citaService.guardarCita(cita);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
