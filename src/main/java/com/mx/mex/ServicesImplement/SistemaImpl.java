package com.mx.mex.ServicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.EmpleadosMPDTO;
import com.mx.mex.Repository.SistemaRepository;
import com.mx.mex.Services.ISistema;



@Service
public class SistemaImpl implements ISistema{
		
	@Autowired
	private SistemaRepository sistemaRepository;

	@Override
	public String validarEmpleado(EmpleadosMPDTO datos) {
		Integer respuesta = sistemaRepository.validarEmpleado(datos);
		String respuestaFinal="";
		
		if(respuesta==0) {
			respuestaFinal="Datos Incorrectos";
			System.out.println(datos.getUsuarioMP());
			System.out.println(datos.getPasswordMP());
		}else {
			respuestaFinal="Autorizado";
		}
		return respuestaFinal;
	}

	@Override
	public String insertarEmpleado(EmpleadosMPDTO datos) {
		Integer respuesta = sistemaRepository.insertarEmpleado(datos);
		String respuestaFinal="";
		
		if(respuesta==0) {
			respuestaFinal="Datos Incorrectos";
			System.out.println(datos.getUsuarioMP());
			System.out.println(datos.getPasswordMP());
		}else {
			respuestaFinal="Usuario Agregado";
		}
		return respuestaFinal;
	}
		
}


