package com.mx.mex.Dto;

import java.sql.Date;

public class EmpleadosMPDTO {
	
	private Long idEmpleadoMP;
	private String nombreMP;
	private String usuarioMP;
	private String passwordMP;
	private Long edadMP;
	private Date fechaIngresoMP;
	private Long loginMP;
	
	public Long getLoginMP() {
		return loginMP;
	}
	public void setLoginMP(Long loginMP) {
		this.loginMP = loginMP;
	}
	public Long getIdEmpleadoMP() {
		return idEmpleadoMP;
	}
	public void setIdEmpleadoMP(Long idEmpleadoMP) {
		this.idEmpleadoMP = idEmpleadoMP;
	}
	public String getNombreMP() {
		return nombreMP;
	}
	public void setNombreMP(String nombreMP) {
		this.nombreMP = nombreMP;
	}
	public String getUsuarioMP() {
		return usuarioMP;
	}
	public void setUsuarioMP(String usuarioMP) {
		this.usuarioMP = usuarioMP;
	}
	public String getPasswordMP() {
		return passwordMP;
	}
	public void setPasswordMP(String passwordMP) {
		this.passwordMP = passwordMP;
	}
	public Long getEdadMP() {
		return edadMP;
	}
	public void setEdadMP(Long edadMP) {
		this.edadMP = edadMP;
	}
	public Date getFechaIngresoMP() {
		return fechaIngresoMP;
	}
	public void setFechaIngresoMP(Date fechaIngresoMP) {
		this.fechaIngresoMP = fechaIngresoMP;
	}
}
