package com.mx.mex.Repository;

import com.mx.mex.Dto.EmpleadosMPDTO;


public interface SistemaRepository {
	public Integer validarEmpleado(EmpleadosMPDTO datos);
	public Integer insertarEmpleado(EmpleadosMPDTO datos);
}
