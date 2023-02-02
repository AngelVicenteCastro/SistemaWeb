package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.entities.UsuariosAdmin;

public interface UsuariosAdminService {

	List<UsuariosAdminDTO> obtenerUsuarios();
	
	List<UsuariosAdmin> obtenerUsuariosHibernate();
	
	String insertUsuariosHibernate(UsuariosAdminDTO datos);
	
	String deleteUsuariosHibernate(UsuariosAdminDTO datos);
	
	String updateUsuariosHibernate(UsuariosAdmin datos);
}
