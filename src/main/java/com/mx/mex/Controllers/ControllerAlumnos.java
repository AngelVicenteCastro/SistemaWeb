package com.mx.mex.Controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.mex.Dto.Alumnos;
import com.mx.mex.Services.IAlumnos;

@Controller
@RequestMapping("Alumnos")
public class ControllerAlumnos {
	
	@Autowired
	private IAlumnos iAlumnos;
	
	@RequestMapping("/getAlumnos")
	public String getAlumno() {
		List<Alumnos> lista = new ArrayList<Alumnos>();
		lista = iAlumnos.getAlumno();
		
		for (Alumnos run : lista) {
			System.out.println("ID ALUMNO : "+run.getIdAlumno());
			System.out.println("SALON : "+run.getSalon());
			System.out.println("NOMBRE : "+run.getNombre());
			
		}
		return "Inicio";
	}
	
	@RequestMapping("/insertAlumnos")
	public String insertAlumno() {
		Alumnos nuevo = new Alumnos();
		nuevo.setNombre("Pedro");
		nuevo.setSalon(new BigDecimal(1));
		
		System.out.println(iAlumnos.insertAlumno(nuevo));
		
		return "Inicio";
	}
	
	@RequestMapping("/deleteAlumnos")
	public String deleteAlumno() {
		Alumnos nuevo = new Alumnos();
		nuevo.setIdAlumno(new BigDecimal (2));
		
		System.out.println(iAlumnos.deleteAlumno(nuevo));
		
		return "Inicio";
	}
	@RequestMapping("/updateAlumnos")
	public String updateAlumno() {
		Alumnos nuevo = new Alumnos();
		nuevo.setIdAlumno(new BigDecimal(4));
		nuevo.setNombre("ALEXIS");
		nuevo.setSalon(new BigDecimal(2));
		
		System.out.println(iAlumnos.updateAlumno(nuevo));
		
		return "Inicio";
	}
}
