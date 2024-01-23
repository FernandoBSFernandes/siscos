package br.com.softwareservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.softwareservice.entidades.Funcionario;
import br.com.softwareservice.util.EntityManagerUtil;

public class LoginDAO {

	public Funcionario login(String login, String senha){
		EntityManager entityManager = EntityManagerUtil.createEntityManager();

		try{
			StringBuffer sbf= new StringBuffer("");
			sbf.append(" select f ");
			sbf.append(" from Funcionario f ");
			sbf.append(" where f.login = :login ");
			sbf.append(" and f.senha = :senha ");

			TypedQuery<Funcionario> typedQuery = (TypedQuery<Funcionario>) entityManager.createQuery(sbf.toString(), Funcionario.class);
			
			typedQuery.setParameter("login", login);
			typedQuery.setParameter("senha", senha);
			
			Funcionario funcionario = typedQuery.getSingleResult();
			
			return funcionario;

		} catch (NoResultException e){
			return null;
		}
	}
}
