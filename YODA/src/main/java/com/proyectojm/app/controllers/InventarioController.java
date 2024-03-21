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
import com.proyectojm.app.service.IServiceInventario;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/inventario")
public class InventarioController {
	
	@Autowired
	private IServiceInventario inventarioService;
	
	
	@PutMapping(value = "/actualizar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@RequestBody InventarioDto inventario) {
		try {
			inventarioService.modificarPieza(inventario);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	@GetMapping(value = "/verTodos")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<InventarioDto> verTodos() {
		List<InventarioDto> listaInventario = null;
		try {
			listaInventario = inventarioService.recuperarTodasLasPiezas();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listaInventario;
	}
	
	@PostMapping(value = "/buscar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<InventarioDto> buscar(@RequestBody InventarioDto inventario) {
		List<InventarioDto> listaEncontrados = null;
		System.out.println(inventario.getDescripcion());
		listaEncontrados = inventarioService.buscador(inventario.getDescripcion());
		
		return listaEncontrados;
	}
	
	
}
