package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.Trabajadores;

public interface ITrabajadores {
	
	public List<Trabajadores> getTrabajadores();
	
	public Trabajadores obtieneTrabajadoresId(Trabajadores idTrabajador);
	
	public String insertTrabajadores(Trabajadores nuevoTrabajador);
	
	public String deleteTrabajadores(Trabajadores nuevoTrabajador);
	
	public String updateTrabajadores (Trabajadores nuevoTrabajador);
	
}
