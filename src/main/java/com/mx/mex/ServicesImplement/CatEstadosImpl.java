package com.mx.mex.ServicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Repository.CatEstadosDAO;
import com.mx.mex.Services.CatEstadosService;
import com.mx.mex.entities.CatEstados;

@Service
public class CatEstadosImpl implements CatEstadosService{
	
	@Autowired
	private CatEstadosDAO catEstadosDAO;

	@Override
	public String obtieneEstadosId(CatEstadosDTO id) {
		String respuesta = null;
		
		CatEstados estado = catEstadosDAO.read(id.getIdEstados()); //SELECT * FROM WHERE ID = ID.GETIDESTADOS()
		System.out.println("DATOS -> " + estado.getNombre()+"ABREVIATURA -> "+ estado.getAbreviatura());
		
		if (estado != null) {
			respuesta = "Si existe el registro.!";
		}else {
			respuesta = "NO existe el registro.!";
		}
		return respuesta;
	}

	@Override
	//@Transaccional    se puede usar si en la configuracion no se agrego la confirmacion de cambios
	public String agregarEstado(CatEstadosDTO datos) {
		
		CatEstados objEntiti = new CatEstados(); // INICIAR LOS DATOS DEL OBJETO
		objEntiti.setIdEstados(datos.getIdEstados());
		objEntiti.setNombre(datos.getNombre());
		objEntiti.setAbreviatura(datos.getAbreviatura());
		
		Long agregado = catEstadosDAO.create(objEntiti);
		
		if (agregado != 0) {
			return "Se agrego el registro.!";
		}else {
			return "NO se agrego el registro.!";
		}
	
	}

	@Override
	public String eliminarEstado(CatEstadosDTO id) {
		catEstadosDAO.delete(id.getIdEstados());// Eliminar registro con hibernate
		
		return "Si elimino el registro";
	}

	//ELIMIR DATOS SEGUNDA FORMA VALIDANDO REGLAS
	
	@Override
	public MensajeDTO eliminarEstadoId(CatEstadosDTO id) {
		MensajeDTO mensajeDTO = new MensajeDTO();
		
		try {
			if(id.getIdEstados() != null && id.getIdEstados() != 0) {
				
				CatEstados existeEstado = catEstadosDAO.read(id.getIdEstados());
				
				if(existeEstado != null) {
					catEstadosDAO.delete(id.getIdEstados());
					mensajeDTO.setMensajecorrecto("El estado se elimino correctamente");
				}else {
					mensajeDTO.setMensajecorrecto("El estado no existe");
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
