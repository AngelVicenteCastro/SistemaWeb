package com.mx.mex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "EMPLEADOS",schema= "CHENTE")
public class Empleados {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_EMPLEADO")
	private Long idEmpleado;
	@Column(name="NOMBRE_COMPLETO")
	private String nombreCompleto;
	@Column(name="RFC")
	private String rfc;
	@Column(name="EDAD")
	private Long edad;
	@Column(name="SEXO")
	private String sexo;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="TELEFONO")
	private Long telefono;
	@Column(name="ACTIVO")
	private Long activo;
	
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public Long getActivo() {
		return activo;
	}
	public void setActivo(Long activo) {
		this.activo = activo;
	}
	
	
}

/*
(	"ID_EMPLEADO" NUMBER(11,0) NOT NULL ENABLE, 
		"NOMBRE_COMPLETO" VARCHAR2(100 BYTE), 
		"RFC" VARCHAR2(13 BYTE), 
		"EDAD" NUMBER(3,0), 
		"SEXO" VARCHAR2(1 BYTE), 
		"DIRECCION" VARCHAR2(50 BYTE), 
		"TELEFONO" NUMBER(10,0), 
		"ACTIVO" NUMBER(1,0), */