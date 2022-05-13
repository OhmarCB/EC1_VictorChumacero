package com.example.EVC1.service;

import java.util.List;

import com.example.EVC1.dto.ProfesorDTORequest;
import com.example.EVC1.dto.ProfesorDTOResponse;

public interface IProfesorService {

	public void guardarProfesor(ProfesorDTORequest prof);
	
	public void editarProfesor(ProfesorDTORequest prof);
	
	public void eliminarProfesor(Integer id);
	
	public List<ProfesorDTOResponse> listarProfesores();
	
	public ProfesorDTOResponse obtenerProfesor(Integer id);
}
