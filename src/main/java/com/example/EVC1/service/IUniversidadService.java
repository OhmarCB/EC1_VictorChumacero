package com.example.EVC1.service;

import java.util.List;

import com.example.EVC1.dto.UniversidadDTORequest;
import com.example.EVC1.dto.UniversidadDTOResponse;

public interface IUniversidadService {

	public void guardarUniversidad(UniversidadDTORequest uni);
	
	public void editarUniversidad(UniversidadDTORequest uni);
	
	public void eliminarUniversidad(Integer id);
	
	public List<UniversidadDTOResponse> listarUniversidades();
	
	public UniversidadDTOResponse obtenerUniversidad(Integer id);
}
