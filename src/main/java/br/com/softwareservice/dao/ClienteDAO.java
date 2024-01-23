package br.com.softwareservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.softwareservice.entidades.Cliente;
import br.com.softwareservice.util.EntityManagerUtil;

public class ClienteDAO {

	public Cliente buscarCliente(String cpf) {
		
		EntityManager entityManager = EntityManagerUtil.createEntityManager();
		
		StringBuffer sbf = new StringBuffer("");
		sbf.append(" select c ");
		sbf.append(" from Cliente c ");
		sbf.append(" where c.cpf = :cpf ");
		
		TypedQuery<Cliente> typedQuery = (TypedQuery<Cliente>) entityManager.createQuery(sbf.toString(), Cliente.class);
		typedQuery.setParameter("cpf", cpf);
		
		try{
			Cliente cliente = typedQuery.getSingleResult();
			return cliente;
		} catch (NoResultException e){
			return null;
		}
	}
}