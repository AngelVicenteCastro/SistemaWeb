package com.mx.mex.RepositoryImplement;

import org.springframework.stereotype.Repository;

import com.mx.mex.Repository.CatEstadosDAO;
import com.mx.mex.entities.CatEstados;

@Repository
public class CatEstadosDAOImpl extends GenericDAO<CatEstados,Long> implements CatEstadosDAO{

}
