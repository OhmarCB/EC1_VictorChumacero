package com.example.EVC1.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="universidades")
@Entity
public class Universidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUni;
	private String uni;
	
	@OneToOne
	@JoinColumn(name="id_malla", nullable=false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition =
	"foreign key(id_malla) references mallas_curriculares(id_malla)"))
	private MCurricular malla;
	
	public Universidad() {
		super();
	}

	public Integer getIdUniversidad() {
		return idUni;
	}

	public void setIdUniversidad(Integer idUniversidad) {
		this.idUni = idUniversidad;
	}

	public String getUniversidad() {
		return uni;
	}

	public void setUniversidad(String universidad) {
		this.uni = universidad;
	}
}
