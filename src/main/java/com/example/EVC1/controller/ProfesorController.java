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

import com.example.EVC1.dto.ProfesorDTORequest;
import com.example.EVC1.dto.ProfesorDTOResponse;
import com.example.EVC1.service.IProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {

	@Autowired public IProfesorService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTOResponse>> listarProfesores(){
		
		return new ResponseEntity<List<ProfesorDTOResponse>>(service.listarProfesores(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProfesorDTORequest prof){
		service.guardarProfesor(prof);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProfesorDTOResponse> listarPorId(@PathVariable Integer id) {
		
		ProfesorDTOResponse p=service.obtenerProfesor(id);
		if(p!=null)
			return new ResponseEntity<ProfesorDTOResponse>(p,HttpStatus.OK);
		
		return new ResponseEntity<ProfesorDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody ProfesorDTORequest prof){
		
		ProfesorDTOResponse p=service.obtenerProfesor(prof.getIdProfesorDto());
		
		if(p!=null) {
			service.editarProfesor(prof);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProfesorDTOResponse p=service.obtenerProfesor(id);
		
		if(p!=null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
