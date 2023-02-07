package com.mx.mex.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mx.mex.Services.ISistema;



@Controller
@RequestMapping ("iThingsHouse")
public class SistemaController {
	@Autowired
	private ISistema iiThingsHouse;
	
	@RequestMapping (value="/Home")
	public String vistaiThingsHouse() {
		return "Home";
	}
}




	
	
