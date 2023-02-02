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

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Services.UsuariosAdminService;
import com.mx.mex.entities.UsuariosAdmin;

@Controller
@RequestMapping (value="UsuariosAdmin")
public class UsuariosAdminController {

		@Autowired
		private UsuariosAdminService usuariosAdminService;
		
		@ResponseBody
		@RequestMapping (value= "/getUsuariosAdmin",method=RequestMethod.GET,produces="application/json")
		ResponseEntity < List<UsuariosAdminDTO>> obtenerUsuarios() {
			final HttpHeaders httpHeaders = new HttpHeaders();
				
			List<UsuariosAdminDTO> lista = usuariosAdminService.obtenerUsuarios();
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<UsuariosAdminDTO>> (lista, httpHeaders, HttpStatus.OK);	
		}
		
		// ******************* consultas por hibernate **************************** 
		
		/**
		 * Consultar todos los datos por hibernate
		 */
		
		@ResponseBody
		@RequestMapping (value= "/getUsuariosAdminHibernate",method=RequestMethod.GET,produces="application/json")
		ResponseEntity < List<UsuariosAdmin>> obtenerUsuariosHibernate() {
			final HttpHeaders httpHeaders = new HttpHeaders();
				
			List<UsuariosAdmin> lista = usuariosAdminService.obtenerUsuariosHibernate();
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<UsuariosAdmin>> (lista, httpHeaders, HttpStatus.OK);	
		}
		
		// INSERTAR USUARIO ADMIN
		
		@ResponseBody
		@RequestMapping (value= "/insertUsuariosAdminHibernate",method=RequestMethod.POST,produces="application/json")
		ResponseEntity < String> insertUsuariosHibernate(@RequestBody UsuariosAdminDTO datos) {
			final HttpHeaders httpHeaders = new HttpHeaders();
				
			String respuesta = usuariosAdminService.insertUsuariosHibernate(datos);
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
		}
		
		// ELIMINAR USUARIO ADMIN
		
				@ResponseBody
				@RequestMapping (value= "/deleteUsuariosAdminHibernate",method=RequestMethod.POST,produces="application/json")
				ResponseEntity < String> deleteUsuariosHibernate(@RequestBody UsuariosAdminDTO datos) {
					final HttpHeaders httpHeaders = new HttpHeaders();
						
					String respuesta = usuariosAdminService.deleteUsuariosHibernate(datos);
						httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
				}
				
		// ACTUALIZAR USUARIO ADMIN
				
				@ResponseBody
				@RequestMapping (value= "/updateUsuariosAdminHibernate",method=RequestMethod.POST,produces="application/json")
				ResponseEntity < String> updateUsuariosHibernate(@RequestBody UsuariosAdmin datos) {
					final HttpHeaders httpHeaders = new HttpHeaders();
						
					String respuesta = usuariosAdminService.updateUsuariosHibernate(datos);
						httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
				}
}
