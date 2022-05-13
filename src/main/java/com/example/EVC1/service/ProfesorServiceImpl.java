package com.example.EVC1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EVC1.dto.ProfesorDTORequest;
import com.example.EVC1.dto.ProfesorDTOResponse;
import com.example.EVC1.model.Profesor;
import com.example.EVC1.repository.IProfesorRepository;

@Service
public class ProfesorServiceImpl implements IProfesorService{

	@Autowired public IProfesorRepository repository;

	@Override
	public void guardarProfesor(ProfesorDTORequest prof) {
		
		Profesor p = new Profesor();
		p.setIdProfesor(prof.getIdProfesorDto());
		p.setProfesor(prof.getProfesorDto());
		
		repository.save(p);
	}

	@Override
	public void editarProfesor(ProfesorDTORequest prof) {
		
		Profesor p = new Profesor();
		p.setIdProfesor(prof.getIdProfesorDto());
		p.setProfesor(prof.getProfesorDto());
		
		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarProfesor(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<ProfesorDTOResponse> listarProfesores() {
		
		List<ProfesorDTOResponse>lista=new ArrayList<ProfesorDTOResponse>();
		ProfesorDTOResponse p=null;
		
		for(Profesor prof: repository.findAll()) {
			p=new ProfesorDTOResponse();
			p.setIdProfesorDto(prof.getIdProfesor());
			p.setProfesorDto(prof.getProfesor());
			
			lista.add(p);
		}
		
		return lista;
	}

	@Override
	public ProfesorDTOResponse obtenerProfesor(Integer id) {
		
		ProfesorDTOResponse p=new ProfesorDTOResponse();
		Profesor prof=repository.findById(id).orElse(null);
		
		p.setIdProfesorDto(prof.getIdProfesor());
		p.setProfesorDto(prof.getProfesor());
		
		return p;
	}
}
