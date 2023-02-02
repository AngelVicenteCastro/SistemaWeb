package com.mx.mex.RepositoryImplement;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Repository.EmpleadosDAO;
import com.mx.mex.entities.Empleados;

@Repository
public class EmpleadosDAOImpl extends GenericDAO<Empleados,Long> implements EmpleadosDAO{
	
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
	public Integer comprobarEmpleados (String nombreCompleto) {
		
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate.update("UPDATE EMPLEADOS SET NOMBRE_COMPLETO = ? WHERE NOMBRE_COMPLETO = ?", nombreCompleto, nombreCompleto);
	}

}
