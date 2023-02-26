package com.mx.mex.Services;

import com.mx.mex.Dto.EmpleadosMPDTO;

public interface ISistema {
	String validarEmpleado(EmpleadosMPDTO datos);
	String insertarEmpleado(EmpleadosMPDTO datos);
}
