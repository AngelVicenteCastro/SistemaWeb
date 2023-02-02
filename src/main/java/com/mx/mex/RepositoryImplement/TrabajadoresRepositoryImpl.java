package com.mx.mex.RepositoryImplement;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.Trabajadores;
import com.mx.mex.Mapper.TrabajadoresMapper;
import com.mx.mex.Repository.ITrabajadoresRepository;
import com.mx.mex.entities.CatEstados;

@Repository
public class TrabajadoresRepositoryImpl implements ITrabajadoresRepository {
	
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
	public List<Trabajadores> getTrabajadores() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM TRABAJADORES",new TrabajadoresMapper<Trabajadores>());
	}
	
	

	@Override
	public Integer insertTrabajadores(Trabajadores nuevoTrabajador) {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate.update("INSERT INTO TRABAJADORES (ID_TRABAJADOR, NOMBRE, EDAD,SALARIO, FECHA_INGRESO) VALUES (?,?,?,?,?)", 
				nuevoTrabajador.getIdTrabajador(),nuevoTrabajador.getNombre(),nuevoTrabajador.getEdad(),nuevoTrabajador.getSalario(),nuevoTrabajador.getFechaIngreso());
	}

	@Override
	public Integer deleteTrabajadores(Trabajadores nuevoTrabajador) {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(getDataSource());
		Object []idparametro = {nuevoTrabajador.getIdTrabajador()};
		int [] types = {Types.INTEGER};
		return jdbcTemplate.update("DELETE FROM TRABAJADORES WHERE ID_TRABAJADOR = ?", 
				idparametro,types);
	}

	@Override
	public Integer updateTrabajadores(Trabajadores nuevoTrabajador) {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE TRABAJADORES SET NOMBRE = ?,EDAD = ?,SALARIO = ?,FECHA_INGRESO = ?  WHERE ID_TRABAJADOR = ?",nuevoTrabajador.getNombre(),
				nuevoTrabajador.getEdad(),nuevoTrabajador.getSalario(),nuevoTrabajador.getFechaIngreso(),nuevoTrabajador.getIdTrabajador());
	}

	

	@Override
	public Trabajadores obtieneTrabajadoresId(Trabajadores idTrabajador) {
		jdbcTemplate.setDataSource(getDataSource());
		Object []idparametro = {idTrabajador.getIdTrabajador()};
		return jdbcTemplate.queryForObject("SELECT * FROM TRABAJADORES WHERE ID_TRABAJADOR = ?", idparametro, new TrabajadoresMapper<Trabajadores>());
				//("SELECT * FROM TRABAJADORES WHERE ID_TRABAJADOR = ?",new Object[] {idTrabajador},new TrabajadoresMapper<Trabajadores>());
	}
	

}
