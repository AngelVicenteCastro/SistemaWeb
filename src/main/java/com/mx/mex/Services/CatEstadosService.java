package com.mx.mex.Services;

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;

public interface CatEstadosService {
	
	String obtieneEstadosId(CatEstadosDTO id);
	String agregarEstado(CatEstadosDTO datos);
	String eliminarEstado(CatEstadosDTO id);
	
	MensajeDTO eliminarEstadoId(CatEstadosDTO datos);
}
