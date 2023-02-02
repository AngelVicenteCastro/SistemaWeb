package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.Usuario;

public interface InterfaceRepositoryPrincipal {

	public String nombreAlumno(String a, int b, float c);
	
	public List<Usuario> obtenerUsuarios();
		
	
    int edadAlumno(int edad,int anio);
	
}
