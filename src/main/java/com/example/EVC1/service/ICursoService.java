package com.example.EVC1.service;

import java.util.List;

import com.example.EVC1.dto.CursoDTORequest;
import com.example.EVC1.dto.CursoDTOResponse;

public interface ICursoService {

	public void guardarCurso(CursoDTORequest curso);
	
	public void editarCurso(CursoDTORequest curso);
	
	public void eliminarCurso(Integer id);
	
	public List<CursoDTOResponse> listarCursos();
	
	public CursoDTOResponse obtenerCurso(Integer id);
}
