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

import com.example.EVC1.dto.MallaCurricularDTORequest;
import com.example.EVC1.dto.MallaCurricularDTOResponse;
import com.example.EVC1.service.IMallaCurricularService;

@RestController
@RequestMapping("/malla/v1")
public class MCurricularController {

	@Autowired public IMallaCurricularService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaCurricularDTOResponse>> listarMallas(){
		
		return new ResponseEntity<List<MallaCurricularDTOResponse>>(service.listarMallas(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricularDTORequest malla){
		service.guardarMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaCurricularDTOResponse> listarPorId(@PathVariable Integer id) {
		
		MallaCurricularDTOResponse m=service.obtenerMalla(id);
		if(m!=null)
			return new ResponseEntity<MallaCurricularDTOResponse>(m,HttpStatus.OK);
		
		return new ResponseEntity<MallaCurricularDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody MallaCurricularDTORequest malla){
		
		MallaCurricularDTOResponse m=service.obtenerMalla(malla.getIdMallaDto());
		
		if(m!=null) {
			service.editarMalla(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		MallaCurricularDTOResponse m=service.obtenerMalla(id);
		
		if(m!=null) {
			service.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
