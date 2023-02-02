package com.mx.mex.Controllers;

import java.util.List;

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

import com.mx.mex.Dto.ResponseDto;
import com.mx.mex.Dto.Trabajadores;
import com.mx.mex.Services.ITrabajadores;

@Controller
@RequestMapping ("Trabajadores")
public class ControllerTrabajadores {
	
	@Autowired
	private ITrabajadores iTrabajadores;
	
	//get UNICAMENTE RETORNA VALORES
	//POST RECIBE Y RETORNA VALORES
	
	
	/* CODIGOS DE RESPUESTA HTTP
	 * 200 = PETICIÓN EXITOSA
	 * 202 = PETICIÓN REALIZADA CORRECTAMENTE
	 * 404 = NO SE ENCONTRO EL SERVICIO
	 * 500 = EXCEPCIÓN INTERNA (SE REVISA EN EL CODIGO)
	 * 503 = PERMISOS DENEGADOS (SE REVISA EN EL CODIGO)
	 * 404 = BAD REQUEST (PETICIÓN INCORRECTA) (QUIERE DECIR QUE TE EQUIVOCASTE EN EL FORMATO DE LA PETICIÓN, A LO MEJOR MANDASTE
	 * UNA PETICIÓN DE TIPO GET, CUANDO TU SERVICIO ES DE TIPO POST)
	 * 
	 * */ 
	
	@RequestMapping (value= "/Practica")
	public String vistaTrabajadores() {return "Practica";}
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE VALORES
	@RequestMapping (value= "/getTrabajadores",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity < List<Trabajadores>> getTrabajadores() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Trabajadores> lista= iTrabajadores.getTrabajadores();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <List<Trabajadores>> (lista, httpHeaders, HttpStatus.OK);	
	}
	
	@ResponseBody
	@RequestMapping (value= "/getTrabajadoresPorId",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity <Trabajadores> consultarPorId(@RequestBody Trabajadores idTrabajador) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		Trabajadores lista = iTrabajadores.obtieneTrabajadoresId(idTrabajador);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <Trabajadores> (lista, httpHeaders, HttpStatus.OK);	
	}
	
	@RequestMapping (value= "/insertTrabajadores",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity < ResponseDto> insertTrabajadores(@RequestBody Trabajadores nuevoTrabajador) {
		final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto respuesta = new ResponseDto();
		    respuesta.setMessage(iTrabajadores.insertTrabajadores(nuevoTrabajador));
		    respuesta.setCode(0);
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
	}
	
	@RequestMapping (value= "/deleteTrabajadores",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity < ResponseDto> deleteTrabajadores(@RequestBody Trabajadores nuevoTrabajador) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto respuesta = new ResponseDto();
	    respuesta.setMessage(iTrabajadores.deleteTrabajadores(nuevoTrabajador));
	    respuesta.setCode(0);
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
	}
	
	@RequestMapping (value= "/updateTrabajadores",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity < ResponseDto> updateTrabajadores(@RequestBody Trabajadores nuevoTrabajador) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto respuesta = new ResponseDto();
			respuesta.setMessage(iTrabajadores.updateTrabajadores(nuevoTrabajador));
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity < ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
	}
}
