package br.com.softwareservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.softwareservice.util.EntityManagerUtil;

public class DAOGenerico {

	public EntityManager entityManager = EntityManagerUtil.createEntityManager();

	public void salvar(Object entidade) {

		try{
			entityManager.getTransaction().begin();
			entityManager.persist(entidade);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e){
			if (entityManager.getTransaction().isActive() || entityManager.getTransaction() != null ){
				entityManager.getTransaction().rollback();
				e.getMessage();
			}
		} finally {
			entityManager.close();
		}
	}
	
	public void excluir(Object entidade) {

		try{
			entityManager.getTransaction().begin();
			entityManager.remove(entidade);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e){
			if (entityManager.getTransaction().isActive() || entityManager.getTransaction() != null ){
				entityManager.getTransaction().rollback();
				e.getMessage();
			}
		} finally {
			entityManager.close();
		}
	}
	
}