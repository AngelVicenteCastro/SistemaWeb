package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.Alumnos;
import com.mx.mex.Repository.IAlumnosRepository;
import com.mx.mex.Services.IAlumnos;


@Service
public class AlumnosServicesImpl implements IAlumnos{

	@Autowired
	private IAlumnosRepository iAlumnosRepository;
	@Override
	public List<Alumnos> getAlumno() {
		// TODO Auto-generated method stub
		return iAlumnosRepository.getAlumno();
	}
	@Override
	public String insertAlumno(Alumnos nuevoAlumno) {
		// TODO Auto-generated method stub
		Integer respuesta=iAlumnosRepository.insertAlumno(nuevoAlumno);
		String respuestaFinal="";
		
		if (respuesta == 0) {
			respuestaFinal="No se inserto";
			
		}else {
			respuestaFinal="Se inserto";

		}
		return respuestaFinal;
	}
	@Override
	public String deleteAlumno(Alumnos nuevoAlumno) {
		iAlumnosRepository.deleteAlumno(nuevoAlumno);
		Integer respuesta=iAlumnosRepository.deleteAlumno(nuevoAlumno);
		
		if (respuesta==0) 
		return "No se eliminó";	
		
		return "Se eliminó";
	}
	@Override
	public String updateAlumno(Alumnos nuevoAlumno) {
		iAlumnosRepository.updateAlumno(nuevoAlumno);
		Integer respuesta = iAlumnosRepository.updateAlumno(nuevoAlumno);
		if(respuesta == 0) {
			return "No se actualizo";
		}else {
			return "Se actualizo correctamente";
		}
		
		
	}

}
