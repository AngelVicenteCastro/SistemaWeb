package com.mx.mex.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRABAJADORES",schema = "CHENTE")
public class Trabajadores {
		
	@Id
	@Column(name="ID_TRABAJADOR")
	private Long idTrabajador;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="EDAD")
	private Long edad;
	@Column(name="SALARIO")
	private Long salario;
	@Column(name="FECHA_INGRESO")
	private Date fecha;
	
	
	public Long getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(Long idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public Long getSalario() {
		return salario;
	}
	public void setSalario(Long salario) {
		this.salario = salario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
}
