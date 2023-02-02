package com.mx.mex.ServicesImplement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.Trabajadores;

import com.mx.mex.Repository.ITrabajadoresRepository;
import com.mx.mex.Services.ITrabajadores;



@Service
public class TrabajadoresImpl implements ITrabajadores{
	
	@Autowired
	private ITrabajadoresRepository iTrabajadoresRepository;

	@Override
	public List<Trabajadores> getTrabajadores() {
		// TODO Auto-generated method stub
		return iTrabajadoresRepository.getTrabajadores();
	}
	
	


	@Override
	public String insertTrabajadores(Trabajadores nuevoTrabajador) {
		// TODO Auto-generated method stub
		Integer respuesta = iTrabajadoresRepository.insertTrabajadores(nuevoTrabajador);
		String respuestaFinal="";
		
		if(respuesta==0) {
			respuestaFinal="NO SE INSERTO";
		}else {
			respuestaFinal="SI SE INSERTO";
		}
		return respuestaFinal;
	}


	@Override
	public String deleteTrabajadores(Trabajadores nuevoTrabajador) {
		// TODO Auto-generated method stub
		Integer respuesta = iTrabajadoresRepository.deleteTrabajadores(nuevoTrabajador);
		String respuestaFinal="";
		
		if(respuesta==0) {
			respuestaFinal="NO SE ELIMINO";
		}else {
			respuestaFinal="SI SE ELIMINO CORRECTAMENTE";
		}
		return respuestaFinal;
	}


	@Override
	public String updateTrabajadores(Trabajadores nuevoTrabajador) {
		// TODO Auto-generated method stub
		Integer respuesta = iTrabajadoresRepository.updateTrabajadores(nuevoTrabajador);
		String respuestaFinal="";
		
		if(respuesta==0) {
			respuestaFinal="ERROR AL ACTUALIZAR";
		}else {
			respuestaFinal="SI SE ACTUALIZO CORRECTAMENTE";
		}
		return respuestaFinal;
	}




	@Override
	public Trabajadores obtieneTrabajadoresId(Trabajadores idTrabajador) {
		
		return iTrabajadoresRepository.obtieneTrabajadoresId(idTrabajador);
		
	}

}
