package com.mx.mex.ServicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.EmpleadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Repository.EmpleadosDAO;
import com.mx.mex.Services.EmpleadosService;
import com.mx.mex.entities.Empleados;

@Service
public class EmpleadosImpl implements EmpleadosService{
	
	@Autowired
	private EmpleadosDAO empleadosDAO;
	
	@Override
	public String obtenerEmpleados(EmpleadosDTO idEmpleado) {
		try {
		Empleados empleado = empleadosDAO.read(idEmpleado.getIdEmpleado()); //SELECT * FROM WHERE ID = ID.GETIDESTADOS()
		System.out.println("DATOS -> " + empleado.getNombreCompleto()+"RFC -> "+ empleado.getRfc());
		
		if (empleado != null) {
			return "Si existe el registro.!";
		}else {
			return  "NO existe el registro.!";
		}}catch(Exception e ) {
			return  "NO existe el registro.!";
		}
		
	}

	@Override
	public String agregarEmpleado(EmpleadosDTO datos) {
		
		Empleados objEntiti = new Empleados(); // INICIAR LOS DATOS DEL OBJETO
		objEntiti.setIdEmpleado(datos.getIdEmpleado());
		objEntiti.setNombreCompleto(datos.getNombreCompleto());
		objEntiti.setRfc(datos.getRfc());
		objEntiti.setEdad(datos.getEdad());
		objEntiti.setSexo(datos.getSexo());
		objEntiti.setDireccion(datos.getDireccion());
		objEntiti.setTelefono(datos.getTelefono());
		objEntiti.setActivo(datos.getActivo());
		
		//Empleados existe = EmpleadosDAO.read(datos.getNombreCompleto());
		Integer comprobar = empleadosDAO.comprobarEmpleados(datos.getNombreCompleto());
		if(comprobar==0) {
			//System.out.println("Comparacion es igual a: "+ comprobar.toString());
			Long agregado = empleadosDAO.create(objEntiti);
			if(agregado != 0) {
			return "Se agrego el empleado Corretamente";
			}else {
				return "Ocurrio un error al agregar el empleado ";
			}
		}else {
			return "Este Empleado Ya Existe";
			}
		//}
		
	}

	@Override
	public String eliminarEmpleado(EmpleadosDTO datos) {
		try {
			if(datos.getIdEmpleado() != null && datos.getIdEmpleado() != 0) {
				
				Empleados existeEmpleado = empleadosDAO.read(datos.getIdEmpleado());
				
				if(existeEmpleado != null ) {
					//System.out.println("El empleado esta activo: "+ existeEstado.getActivo());
					if(existeEmpleado.getActivo() == 0) {
					empleadosDAO.delete(datos.getIdEmpleado());
					return "El empleado se elimino correctamente";
				}else {
					return "El empleado aun se encuentra laborando";
				}
				
			}else {
				return "El empleado no existe";
			}
			}else {
				return "El Id de empleado insertado es incorercto";
			}
		}catch(Exception e) {
			return "Ocurrio un error al intentar eliminar la informacion";
		}
	}
	
	@Override
	public String updateEmpleado(EmpleadosDTO datos) {
		
		Empleados existeEmpleado = empleadosDAO.read(datos.getIdEmpleado());
		
		if(existeEmpleado != null) {
			if(existeEmpleado.getActivo() == 1) {
				Empleados objEntiti = new Empleados(); // INICIAR LOS DATOS DEL OBJETO
				objEntiti.setIdEmpleado(datos.getIdEmpleado());
				objEntiti.setNombreCompleto(datos.getNombreCompleto());
				objEntiti.setRfc(datos.getRfc());
				objEntiti.setEdad(datos.getEdad());
				objEntiti.setSexo(datos.getSexo());
				objEntiti.setDireccion(datos.getDireccion());
				objEntiti.setTelefono(datos.getTelefono());
				objEntiti.setActivo(datos.getActivo());
			empleadosDAO.update(objEntiti);
			return "Se actualizo el empleado Corretamente";
			}else {
			return "No se puede actualizar los datos de este empleado porque ya no se encuentra laborando";
			}
		}else {
				return "Este empleado no existe";
				}
	}
	

}
