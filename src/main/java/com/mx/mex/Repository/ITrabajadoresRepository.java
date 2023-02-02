package com.mx.mex.Repository;

import java.util.List;


import com.mx.mex.Dto.Trabajadores;

public interface ITrabajadoresRepository {
	
	public List<Trabajadores> getTrabajadores();
	
	public Trabajadores obtieneTrabajadoresId(Trabajadores idTrabajador);
	
	public Integer insertTrabajadores(Trabajadores nuevoTrabajador);
	
	public Integer deleteTrabajadores(Trabajadores nuevoTrabajador);
	
	public Integer updateTrabajadores (Trabajadores nuevoTrabajador);

}
