package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Repository.UsuariosAdminDAO;
import com.mx.mex.Services.UsuariosAdminService;
import com.mx.mex.entities.UsuariosAdmin;

@Service
public class UsuariosAdminImpl implements UsuariosAdminService{

		@Autowired
		private UsuariosAdminDAO usuariosAdminDAO;

		@Override
		public List<UsuariosAdminDTO> obtenerUsuarios() {
			
			return usuariosAdminDAO.obtenerUsuarios();
		}

		@Override
		public List<UsuariosAdmin> obtenerUsuariosHibernate() {
			List<UsuariosAdmin> usuarioAd = usuariosAdminDAO.obtenerUsuariosHibernate();
			
			
			return usuarioAd;
		}

		@Override
		public String insertUsuariosHibernate(UsuariosAdminDTO datos) {
			
			UsuariosAdmin usuariosAdmin = new UsuariosAdmin();//inicializamos el objeto
			
			usuariosAdmin.setIdUser(datos.getIdUser());
			usuariosAdmin.setNombreCompleto(datos.getNombreCompleto());
			usuariosAdmin.setEdad(datos.getEdad());
			usuariosAdmin.setDireccion(datos.getDireccion());
			usuariosAdmin.setEstado(datos.getEstado());
			usuariosAdmin.setRol(datos.getRol());
			
			Integer respuConsulta = usuariosAdminDAO.insertUsuario(usuariosAdmin);
			String respuesta="";
			
			if(respuConsulta == 0) {
				respuesta = "NO SE INSERTO EL USUARIO";
			}else {
				respuesta= "SE INSERTO CORRECTAMENTE";
			}
			
			return respuesta;
		}

		@Override
		public String deleteUsuariosHibernate(UsuariosAdminDTO id) {
			Integer respuConsulta = usuariosAdminDAO.deleteUsuario(id.getIdUser());
			String respuesta="";
			
			if(respuConsulta == 0) {
				respuesta = "ERROR AL ELIMINAR USUARIO";
			}else {
				respuesta= "SE ELIMINO CORRECTAMENTE";
			}
			
			return respuesta;
		}

		@Override
		public String updateUsuariosHibernate(UsuariosAdmin datos) {
			Integer respuConsulta = usuariosAdminDAO.updateUsuario(datos);
			String respuesta="";
			
			if(respuConsulta == 0) {
				respuesta = "ERROR AL ACTUALIZAR USUARIO";
			}else {
				respuesta= "SE ACTUALIZO CORRECTAMENTE";
			}
			
			return respuesta;
		}
}
