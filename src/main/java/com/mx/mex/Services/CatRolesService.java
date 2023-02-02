package com.mx.mex.Services;

import com.mx.mex.Dto.CatRolesDTO;
import com.mx.mex.Dto.MensajeDTO;

public interface CatRolesService {
	
	String obtieneRolesId(CatRolesDTO id);
	String agregarRoles(CatRolesDTO datos);
	String eliminarRoles(CatRolesDTO id);
	
	MensajeDTO eliminarRolesId(CatRolesDTO id);
}
