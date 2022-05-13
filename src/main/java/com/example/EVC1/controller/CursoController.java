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

import com.example.EVC1.dto.CursoDTORequest;
import com.example.EVC1.dto.CursoDTOResponse;
import com.example.EVC1.service.ICursoService;

@RestController
@RequestMapping("/curso/v1")
public class CursoController {

	@Autowired public ICursoService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTOResponse>> listarCursos(){
		
		return new ResponseEntity<List<CursoDTOResponse>>(service.listarCursos(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody CursoDTORequest curso){
		service.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<CursoDTOResponse> listarPorId(@PathVariable Integer id) {
		
		CursoDTOResponse c=service.obtenerCurso(id);
		if(c!=null)
			return new ResponseEntity<CursoDTOResponse>(c,HttpStatus.OK);
		
		return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody CursoDTORequest curso){
		
		CursoDTOResponse c=service.obtenerCurso(curso.getIdCursoDto());
		
		if(c!=null) {
			service.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		CursoDTOResponse c=service.obtenerCurso(id);
		
		if(c!=null) {
			service.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
