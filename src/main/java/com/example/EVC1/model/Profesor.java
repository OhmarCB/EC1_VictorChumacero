package com.example.EVC1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="profesores")
@Entity
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProf;
	private String profesor;
	
	@ManyToMany(mappedBy = "profesores", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Curso>cursos=new ArrayList<Curso>();
	
	public Profesor() {
		super();
	}

	public Integer getIdProfesor() {
		return idProf;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProf = idProfesor;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
}
