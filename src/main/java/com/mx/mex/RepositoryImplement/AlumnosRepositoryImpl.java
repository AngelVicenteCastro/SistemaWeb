package com.mx.mex.RepositoryImplement;


import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.Alumnos;
import com.mx.mex.Mapper.AlumnhosMapper;
import com.mx.mex.Repository.IAlumnosRepository;


@Repository
public class AlumnosRepositoryImpl implements IAlumnosRepository {
	
	@ Autowired
	DataSource dataSource; //CONTIENE LA CONEXION A LA BASE DE DATOS
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(); // NOS PERMITE EJECUTAR LAS CONSULTAS DE LA BD
	
	@Override
	public List<Alumnos> getAlumno() {
		jdbcTemplate.setDataSource(getDataSource()); //SE ASIGNA CONEXIOON A NUESTRO OBJETO JDBC TEMPLATE
		return jdbcTemplate.query("SELECT * FROM ALUMNOS", new AlumnhosMapper<Alumnos>());
	}

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
	public Integer insertAlumno(Alumnos nuevoAlumno) {
		
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO ALUMNOS(NOMBRE,SALON)VALUES(?,?)",nuevoAlumno.getNombre(),nuevoAlumno.getSalon());
	}

	@Override
	public Integer deleteAlumno(Alumnos nuevoAlumno) {
		jdbcTemplate.setDataSource(getDataSource());
		Object []idparametro = {nuevoAlumno.getIdAlumno()};
		int [] types = {Types.INTEGER};
		
		return jdbcTemplate.update("DELETE FROM ALUMNOS WHERE ID_ALUMNO = ?",idparametro,types);
	}

	@Override
	public Integer updateAlumno(Alumnos nuevoAlumno) {
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate.update("UPDATE ALUMNOS SET NOMBRE = ?,SALON = ? WHERE ID_ALUMNO = ?",nuevoAlumno.getNombre(),nuevoAlumno.getSalon(),nuevoAlumno.getIdAlumno());
	}

}
