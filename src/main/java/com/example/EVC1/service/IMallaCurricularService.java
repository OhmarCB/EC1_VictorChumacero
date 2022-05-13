package com.example.EVC1.service;

import java.util.List;

import com.example.EVC1.dto.MallaCurricularDTORequest;
import com.example.EVC1.dto.MallaCurricularDTOResponse;

public interface IMallaCurricularService {
	
	public void guardarMalla(MallaCurricularDTORequest malla);
	
	public void editarMalla(MallaCurricularDTORequest malla);
	
	public void eliminarMalla(Integer id);
	
	public List<MallaCurricularDTOResponse> listarMallas();
	
	public MallaCurricularDTOResponse obtenerMalla(Integer id);
}
