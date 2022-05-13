package com.example.EVC1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.EVC1.dto.UniversidadDTORequest;
import com.example.EVC1.dto.UniversidadDTOResponse;
import com.example.EVC1.service.IUniversidadService;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadController {

	@Autowired public IUniversidadService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UniversidadDTOResponse>> listarUniversidades(){
		
		return new ResponseEntity<List<UniversidadDTOResponse>>(service.listarUniversidades(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UniversidadDTORequest uni){
		service.guardarUniversidad(uni);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UniversidadDTOResponse> listarPorId(@PathVariable Integer id) {
		
		UniversidadDTOResponse u=service.obtenerUniversidad(id);
		if(u!=null)
			return new ResponseEntity<UniversidadDTOResponse>(u,HttpStatus.OK);
		
		return new ResponseEntity<UniversidadDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody UniversidadDTORequest uni){
		
		UniversidadDTOResponse u=service.obtenerUniversidad(uni.getIdUniversidadDto());
		
		if(u!=null) {
			service.editarUniversidad(uni);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UniversidadDTOResponse u=service.obtenerUniversidad(id);
		
		if(u!=null) {
			service.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
