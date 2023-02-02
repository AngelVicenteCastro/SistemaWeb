package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.EmpleadosDTO;
import com.mx.mex.entities.Empleados;

public interface EmpleadosDAO extends DAO<Empleados,Long> {
	
	public Integer comprobarEmpleados (String nombreCompleto);
}
