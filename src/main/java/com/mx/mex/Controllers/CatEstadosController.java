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

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Services.CatEstadosService;

@Controller
@RequestMapping (value="CatEstados")
public class CatEstadosController {
	
	@Autowired
	private CatEstadosService catEstadosService;
	
	@ResponseBody
	@RequestMapping (value= "/getEstadoPorId",method=RequestMethod.POST,produces="application/json")
	public String consultarPorId(@RequestBody CatEstadosDTO id) {
		
		String resp = catEstadosService.obtieneEstadosId(id);
		
	return resp;	
	}
	
	@ResponseBody
	@RequestMapping (value= "/insertEstadoPorId",method=RequestMethod.POST,produces="application/json")
	public String agregarNuevo(@RequestBody CatEstadosDTO datos) {
		
		String resp = catEstadosService.agregarEstado(datos);
		
	return resp;	
	}
	
	@ResponseBody
	@RequestMapping (value= "/deleteEstadoPorId",method=RequestMethod.POST,produces="application/json")
	ResponseEntity <String> eliminarEstado(@RequestBody CatEstadosDTO id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respDel = catEstadosService.eliminarEstado(id);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <String>(respDel,httpHeaders,HttpStatus.OK);	
	}
	
	@ResponseBody
	@RequestMapping (value= "/deleteEstadoId",method=RequestMethod.POST,produces="application/json")
	public MensajeDTO eliminarEstadoId(@RequestBody CatEstadosDTO id) {
		
	return catEstadosService.eliminarEstadoId(id);	
	}
}
