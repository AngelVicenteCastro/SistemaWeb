package com.mx.mex.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.Usuario;
import com.mx.mex.Mapper.UsuariosListMapper;
import com.mx.mex.Repository.InterfaceRepositoryPrincipal;


// ESTA CLASE ES PARA LA EJECUCIÓN DE CONSULTAS HACIA LA BASE DE DATOS

@Repository
public class RepositoryImplementPrincipal implements InterfaceRepositoryPrincipal{

	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	public List<Usuario> obtenerUsuarios() {
		jdbcTemplate.setDataSource(getDatasource());
		return jdbcTemplate.query("SELECT * FROM USUARIOS",
				new UsuariosListMapper<Usuario>());
	}

	public int edadAlumno(int edad, int anio) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	public String nombreAlumno(String a, int b, float c) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
