package com.mx.mex.RepositoryImplement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.EmpleadosMPDTO;
import com.mx.mex.Repository.SistemaRepository;

@Repository
public class SistemaRepositoryImpl implements SistemaRepository{
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Integer validarEmpleado(EmpleadosMPDTO datos) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE TRABAJADORES_MP SET LOGIN = 1  WHERE USUARIO = ? AND CONTRASEÑA = ?",datos.getUsuarioMP(),
				datos.getPasswordMP());
	}

	@Override
	public Integer insertarEmpleado(EmpleadosMPDTO datos) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO TRABAJADORES_MP (NOMBRE,USUARIO,CONTRASEÑA,EDAD,FECHA_INGRESO,LOGIN) VALUES (?,?,?,?,?,?)",datos.getNombreMP(),datos.getUsuarioMP(),
				datos.getPasswordMP(),datos.getEdadMP(),datos.getFechaIngresoMP(),datos.getLoginMP());
	}
	
	
}
