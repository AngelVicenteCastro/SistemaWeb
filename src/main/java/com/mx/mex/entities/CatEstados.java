package com.mx.mex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAT_ESTADOS",schema = "CHENTE")
public class CatEstados {
	@Id
	@Column(name="ID_ESTADO")
	private Long idEstados;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="ABREVIATURA")
	private String abreviatura;
	
	
	public Long getIdEstados() {
		return idEstados;
	}
	public void setIdEstados(Long idEstados) {
		this.idEstados = idEstados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
}
