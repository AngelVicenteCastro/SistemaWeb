package com.mx.mex.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mx.mex.Services.ISistema;



@Controller
@RequestMapping ("Sistema")
public class SistemaController {
	@Autowired
	private ISistema iSistema;
	
	@RequestMapping (value= "/LoginTienda")
	public String vistaTrabajadores() {return "LoginTienda";}
}




	
	
