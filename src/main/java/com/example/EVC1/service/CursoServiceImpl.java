package com.example.EVC1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EVC1.dto.CursoDTORequest;
import com.example.EVC1.dto.CursoDTOResponse;
import com.example.EVC1.model.Curso;
import com.example.EVC1.repository.ICursoRepository;

@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired public ICursoRepository repository;

	@Override
	public void guardarCurso(CursoDTORequest curso) {

		Curso c = new Curso();
		c.setIdCurso(curso.getIdCursoDto());
		c.setCurso(curso.getCursoDto());
		c.setDescripcion(curso.getDescripcionDto());
		
		repository.save(c);
	}

	@Override
	public void editarCurso(CursoDTORequest curso) {
		
		Curso c = new Curso();
		c.setIdCurso(curso.getIdCursoDto());
		c.setCurso(curso.getCursoDto());
		c.setDescripcion(curso.getDescripcionDto());
		
		repository.saveAndFlush(c);
	}

	@Override
	public void eliminarCurso(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<CursoDTOResponse> listarCursos() {

		List<CursoDTOResponse>lista=new ArrayList<CursoDTOResponse>();
		CursoDTOResponse c=null;
		
		for(Curso curso: repository.findAll()) {
			c=new CursoDTOResponse();
			c.setIdCursoDto(curso.getIdCurso());
			c.setCursoDto(curso.getCurso());
			c.setDescripcionDto(curso.getDescripcion());
			
			lista.add(c);
		}
		
		return lista;
	}

	@Override
	public CursoDTOResponse obtenerCurso(Integer id) {
		CursoDTOResponse c=new CursoDTOResponse();
		Curso curso=repository.findById(id).orElse(null);
		
		c.setIdCursoDto(curso.getIdCurso());
		c.setCursoDto(curso.getCurso());
		c.setDescripcionDto(curso.getDescripcion());
		
		return c;
	}
}
