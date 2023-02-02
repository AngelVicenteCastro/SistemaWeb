package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.entities.UsuariosAdmin;

public interface UsuariosAdminDAO {

	List<UsuariosAdminDTO> obtenerUsuarios();
	List<UsuariosAdmin> obtenerUsuariosHibernate();
	
	Integer insertUsuario(UsuariosAdmin datos);
	
	Integer deleteUsuario(Long idUser);
	
	Integer updateUsuario(UsuariosAdmin datos);
}
