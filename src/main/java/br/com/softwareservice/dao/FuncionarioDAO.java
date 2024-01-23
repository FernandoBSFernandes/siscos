package br.com.softwareservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.softwareservice.entidades.Funcionario;
import br.com.softwareservice.util.EntityManagerUtil;

public class FuncionarioDAO {

	public Funcionario buscarFuncionario(String matricula) {
		EntityManager entityManager = EntityManagerUtil.createEntityManager();
		
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" select f ");
		sbf.append(" from Funcionario f ");
		sbf.append(" where c.matricula = :matricula ");
		
		TypedQuery<Funcionario> typedQuery = (TypedQuery<Funcionario>) entityManager.createQuery(sbf.toString(), Funcionario.class);
		typedQuery.setParameter("matricula", matricula);
		
		try{
			Funcionario funcionario = typedQuery.getSingleResult();
			return funcionario;
			
		} catch (NoResultException e){
			return null;
		}
	}

}
