package com.mx.mex.RepositoryImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Repository.UsuariosAdminDAO;
import com.mx.mex.entities.UsuariosAdmin;

@Repository
public class UsuariosAdminDAOImpl implements UsuariosAdminDAO{
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	public DataSource getDataSource() {return dataSource;}
	public void setDataSource(DataSource dataSource) {this.dataSource = dataSource;}
	public JdbcTemplate getJdbcTemplate() {return jdbcTemplate;}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

	@SuppressWarnings("unchecked") // Esta anotacion es para -> @Suprimir advertencias (lineas amarillas)
	@Override
	public List<UsuariosAdminDTO> obtenerUsuarios() {
		jdbcTemplate.setDataSource(getDataSource());
		
		StringBuilder sb = new StringBuilder("SELECT ID_USER,NOMBRE_COMPLETO,EDAD,DIRECCION FROM CHENTE.USUARIOS_ADMIN");
		
		
		
		return (List<UsuariosAdminDTO>) jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {
	         @Override
	         public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	 UsuariosAdminDTO datos = new UsuariosAdminDTO();
	        	 
	        	 datos.setIdUser(rs.getLong("ID_USER"));
			   datos.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
			   datos.setEdad(rs.getString("EDAD"));
			   datos.setDireccion(rs.getString("DIRECCION"));
			  
			   return datos;
		   }
	   });
	}
	
	//CONSULTAR POR HIBERNATE
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UsuariosAdminDAOImpl() {
		
	}
	public UsuariosAdminDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)// COMMIT ---->>>>> LA TRANSACTION ES SOLO PARA EL INSERT, DELETE Y UPDATE
	public List<UsuariosAdmin> obtenerUsuariosHibernate() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
		//criteria.add(Restrictions.eq("ID_USER",1));   //--->>>>SELECT * ESQUEMA.TABLA WHERE ID_USER = 1
		// criteria.addOrder(Order.asc("NOMBRE_COMPLETO"));    ------->>>> ORDER BY
		
		return (List<UsuariosAdmin>) criteria.list();
	}
	
	// INSERTAR UN NUEVO USUARIO 
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer insertUsuario(UsuariosAdmin datos) {
		sessionFactory.getCurrentSession().save(datos); // registrando los datos en la base por hibernate
		//sessionFactory.getCurrentSession().saveOrUpdate(datos); // guardar o actualizar si ya existe
		
		return 1;
	}
	
	// ELIMINAR UN USUARIO
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer deleteUsuario(Long idUser) {
		
		UsuariosAdmin userAdmin = new UsuariosAdmin();
		userAdmin.setIdUser(idUser);
		sessionFactory.getCurrentSession().delete(userAdmin);
		
		return 1;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer updateUsuario(UsuariosAdmin datos) {
		sessionFactory.getCurrentSession().update(datos); // registrando los datos en la base por hibernate
		//sessionFactory.getCurrentSession().saveOrUpdate(datos); // guardar o actualizar si ya existe
		
		return 1;
	}
}
