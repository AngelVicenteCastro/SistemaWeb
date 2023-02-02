package com.mx.mex.Dto;

public class EmpleadosDTO {
	
	private Long idEmpleado;
	private String nombreCompleto;
	private String rfc;
	private Long edad;
	private String sexo;
	private String direccion;
	private Long telefono;
	private Long activo;
	
	public Long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleados(Long idEmpleados) {
		this.idEmpleado = idEmpleados;
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
	"ACTIVO" NUMBER(1,0), 
*/