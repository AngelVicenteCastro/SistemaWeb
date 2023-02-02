package com.mx.mex.Services;

import com.mx.mex.Dto.EmpleadosDTO;
import com.mx.mex.Dto.MensajeDTO;

public interface EmpleadosService {
	
	String obtenerEmpleados(EmpleadosDTO idEmpleado);
	String agregarEmpleado(EmpleadosDTO datos);
	String eliminarEmpleado(EmpleadosDTO datos);
	String updateEmpleado(EmpleadosDTO datos);
}
