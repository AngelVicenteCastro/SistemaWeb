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
import com.mx.mex.Dto.CatRolesDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Services.CatEstadosService;
import com.mx.mex.Services.CatRolesService;

@Controller
@RequestMapping (value="CatRoles")
public class CatRolesController {
	
	@Autowired
	private CatRolesService catRolesService;
	
	@ResponseBody
	@RequestMapping (value= "/getRolesPorId",method=RequestMethod.POST,produces="application/json")
	public String consultarPorId(@RequestBody CatRolesDTO id) {
		
		String resp = catRolesService.obtieneRolesId(id);
		
	return resp;	
	}
	
	@ResponseBody
	@RequestMapping (value= "/insertRolesPorId",method=RequestMethod.POST,produces="application/json")
	public String agregarNuevoRoles(@RequestBody CatRolesDTO datos) {
		
		String resp = catRolesService.agregarRoles(datos);
		
	return resp;	
	}
	
	@ResponseBody
	@RequestMapping (value= "/deleteRolesPorId",method=RequestMethod.POST,produces="application/json")
	ResponseEntity <String> eliminarRoles(@RequestBody CatRolesDTO id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respDel = catRolesService.eliminarRoles(id);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	return new ResponseEntity <String>(respDel,httpHeaders,HttpStatus.OK);	
	}
	
	@ResponseBody
	@RequestMapping (value= "/deleteRolesId",method=RequestMethod.POST,produces="application/json")
	public MensajeDTO eliminarRolesId(@RequestBody CatRolesDTO id) {
		
	return catRolesService.eliminarRolesId(id);	
	}
}
