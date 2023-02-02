package com.mx.mex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAT_ROLES",schema = "CHENTE")
public class CatRoles {

	@Id
	@Column(name="ID_ROL")
	private Long idRol;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

/*
CREATE TABLE "CHENTE"."CAT_ROLES" 
   (	"ID_ROL" NUMBER(11,0) NOT NULL ENABLE, 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"DESCRIPCION" VARCHAR2(100 BYTE)

*/