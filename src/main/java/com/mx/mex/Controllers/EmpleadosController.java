package com.mx.mex.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.EmpleadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Services.EmpleadosService;


@Controller
@RequestMapping (value="Empleados")
public class EmpleadosController {
	
	@Autowired
	private EmpleadosService empleadosService;
	
	@ResponseBody
	@RequestMapping (value= "/getEmpleados",method=RequestMethod.POST,produces="application/json")
	public String consultarPorId(@RequestBody EmpleadosDTO idEmpleado) {
		
		String resp = empleadosService.obtenerEmpleados(idEmpleado);
		
	return resp;	
	}
	
	@ResponseBody
	@RequestMapping (value= "/insertEmpleado",method=RequestMethod.POST,produces="application/json")
	public String agregarNuevo(@RequestBody EmpleadosDTO datos) {
		
		String resp = empleadosService.agregarEmpleado(datos);
		
	return resp;	
	}
	
	@ResponseBody
	@RequestMapping (value= "/deleteEmpleado",method=RequestMethod.POST,produces="application/json")
	public String eliminarEmpleado(@RequestBody EmpleadosDTO datos) {
		
		String resp = empleadosService.eliminarEmpleado(datos);
		
	return resp;	
	}
	
	@ResponseBody
	@RequestMapping (value= "/updateEmpleado",method=RequestMethod.POST,produces="application/json")
	public String updateEmpleado(@RequestBody EmpleadosDTO datos) {
		
		String resp = empleadosService.updateEmpleado(datos);
		
	return resp;	
	}
	
}
