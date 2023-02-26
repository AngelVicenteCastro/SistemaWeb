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
import org.springframework.web.servlet.ModelAndView;

import com.mx.mex.Dto.EmpleadosDTO;
import com.mx.mex.Dto.EmpleadosMPDTO;
import com.mx.mex.Dto.ResponseDto;
import com.mx.mex.Services.ISistema;



@Controller
@RequestMapping ("Sistema")
public class SistemaController {
	@Autowired
	private ISistema iSistema;
	
	@RequestMapping (value= "/LoginTienda")
	public String vistaTienda() {return "LoginTienda";}
	
	@RequestMapping (value= "/Home")
	public String vistaHome() {return "Home";}
	
	@RequestMapping (value= "/LoginMacPlay")
	public ModelAndView  vistaMacPlay() {
		ModelAndView vista = new ModelAndView();
		vista.setViewName("LoginMacPlay");
		return vista;}
	
	@ResponseBody
	@RequestMapping (value= "/validarEmpleado",method=RequestMethod.POST,produces="application/json")
	public  ResponseEntity < ResponseDto> validarEmpleado(@RequestBody EmpleadosMPDTO datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto respuesta = new ResponseDto();
		respuesta.setMessage(iSistema.validarEmpleado(datos));
		respuesta.setCode(0);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
	}
	
	@ResponseBody
	@RequestMapping (value= "/insertarEmpleado",method=RequestMethod.POST,produces="application/json")
	public  ResponseEntity < ResponseDto> insertarEmpleado(@RequestBody EmpleadosMPDTO datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto respuesta = new ResponseDto();
		respuesta.setMessage(iSistema.insertarEmpleado(datos));
		respuesta.setCode(0);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
	}
}




	
	
