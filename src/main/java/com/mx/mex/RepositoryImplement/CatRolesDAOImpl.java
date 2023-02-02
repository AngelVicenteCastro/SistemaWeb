package com.mx.mex.RepositoryImplement;

import org.springframework.stereotype.Repository;

import com.mx.mex.Repository.CatRolesDAO;
import com.mx.mex.entities.CatRoles;

@Repository
public class CatRolesDAOImpl extends GenericDAO<CatRoles,Long> implements CatRolesDAO{

}
