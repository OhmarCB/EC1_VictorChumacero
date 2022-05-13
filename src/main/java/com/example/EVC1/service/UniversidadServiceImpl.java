package com.example.EVC1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EVC1.dto.UniversidadDTORequest;
import com.example.EVC1.dto.UniversidadDTOResponse;
import com.example.EVC1.model.Universidad;
import com.example.EVC1.repository.IUniversidadRepository;

@Service
public class UniversidadServiceImpl implements IUniversidadService{

	@Autowired public IUniversidadRepository repository;

	@Override
	public void guardarUniversidad(UniversidadDTORequest uni) {
		
		Universidad u = new Universidad();
		u.setIdUniversidad(uni.getIdUniversidadDto());
		u.setUniversidad(uni.getUniversidadDto());
		
		repository.save(u);
	}

	@Override
	public void editarUniversidad(UniversidadDTORequest uni) {
		
		Universidad u = new Universidad();
		u.setIdUniversidad(uni.getIdUniversidadDto());
		u.setUniversidad(uni.getUniversidadDto());
		
		repository.saveAndFlush(u);
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<UniversidadDTOResponse> listarUniversidades() {
		
		List<UniversidadDTOResponse>lista=new ArrayList<UniversidadDTOResponse>();
		UniversidadDTOResponse u=null;
		
		for(Universidad uni: repository.findAll()) {
			u=new UniversidadDTOResponse();
			u.setIdUniversidadDto(uni.getIdUniversidad());
			u.setUniversidadDto(uni.getUniversidad());
			
			lista.add(u);
		}
		
		return lista;
	}

	@Override
	public UniversidadDTOResponse obtenerUniversidad(Integer id) {
		
		UniversidadDTOResponse u=new UniversidadDTOResponse();
		Universidad uni=repository.findById(id).orElse(null);
		
		u.setIdUniversidadDto(uni.getIdUniversidad());
		u.setUniversidadDto(uni.getUniversidad());
		return u;
	}
}
