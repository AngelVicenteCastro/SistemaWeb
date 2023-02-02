package com.mx.mex.ServicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.CatRolesDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Repository.CatRolesDAO;
import com.mx.mex.Services.CatRolesService;
import com.mx.mex.entities.CatRoles;

@Service
public class CatRolesImpl implements CatRolesService{
	
	@Autowired
	private CatRolesDAO catRolesDAO;

	@Override
	public String obtieneRolesId(CatRolesDTO id) {
		String respuesta = null;
		
		CatRoles roles = catRolesDAO.read(id.getIdRol()); //SELECT * FROM WHERE ID = ID.GETIDESTADOS()
		System.out.println("DATOS -> " + roles.getNombre()+"DESCRIPCION -> "+ roles.getDescripcion());
		
		if (roles != null) {
			respuesta = "Si existe el registro.!";
		}else {
			respuesta = "NO existe el registro.!";
		}
		return respuesta;
	}

	@Override
	//@Transaccional    se puede usar si en la configuracion no se agrego la confirmacion de cambios
	public String agregarRoles(CatRolesDTO datos) {
		
		CatRoles objEntiti = new CatRoles(); // INICIAR LOS DATOS DEL OBJETO
		objEntiti.setIdRol(datos.getIdRol());
		objEntiti.setNombre(datos.getNombre());
		objEntiti.setDescripcion(datos.getDescripcion());
		
		Long agregado = catRolesDAO.create(objEntiti);
		
		if (agregado != 0) {
			return "Se agrego el registro.!";
		}else {
			return "NO se agrego el registro.!";
		}
	
	}

	@Override
	public String eliminarRoles(CatRolesDTO id) {
		catRolesDAO.delete(id.getIdRol());// Eliminar registro con hibernate
		
		return "Si elimino el registro";
	}

	//ELIMIR DATOS SEGUNDA FORMA VALIDANDO REGLAS
	
	@Override
	public MensajeDTO eliminarRolesId(CatRolesDTO id) {
		MensajeDTO mensajeDTO = new MensajeDTO();
		
		try {
			if(id.getIdRol() != null && id.getIdRol() != 0) {
				
				CatRoles existeEstado = catRolesDAO.read(id.getIdRol());
				
				if(existeEstado != null) {
					catRolesDAO.delete(id.getIdRol());
					mensajeDTO.setMensajecorrecto("El rol se elimino correctamente");
				}else {
					mensajeDTO.setMensajecorrecto("El rol no existe");
				}
				
			}else {
				mensajeDTO.setMensajecorrecto("Los Datos enviados para la consulta son erroneos");
			}
			
		}catch(Exception e) {
			mensajeDTO.setMensajecorrecto("Ocurrio un error al intentar eliminar la informacion");
		}
		
		
		return mensajeDTO;
	}
}
