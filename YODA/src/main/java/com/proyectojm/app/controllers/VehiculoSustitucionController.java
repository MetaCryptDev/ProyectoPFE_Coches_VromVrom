package com.proyectojm.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectojm.app.dto.InventarioDto;
import com.proyectojm.app.dto.VehiculoDto;
import com.proyectojm.app.dto.VehiculoSustitucionDto;
import com.proyectojm.app.service.IServiceInventario;
import com.proyectojm.app.service.IServiceVehiculoSustitucion;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/vehiculoSustitucion")
public class VehiculoSustitucionController {
	
	@Autowired
	private IServiceVehiculoSustitucion servicioVehiculoSustitucion;

		
	@GetMapping(value = "/verTodos")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<VehiculoSustitucionDto> verTodos() {
		List<VehiculoSustitucionDto> listaInventario = null;
		try {
			listaInventario = servicioVehiculoSustitucion.recuperarTodosLosVehiculosSustitucion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listaInventario;
	}
}
