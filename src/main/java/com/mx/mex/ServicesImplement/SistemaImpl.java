package com.mx.mex.ServicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Repository.SistemaRepository;
import com.mx.mex.Services.ISistema;



@Service
public class SistemaImpl implements ISistema{
		
	@Autowired
	private SistemaRepository sistemaRepository;
}


