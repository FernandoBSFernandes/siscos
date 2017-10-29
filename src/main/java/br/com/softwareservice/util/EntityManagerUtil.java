package br.com.softwareservice.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public static EntityManager createEntityManager(){

		EntityManagerFactory factory = null;
		EntityManager entityManager = null;

		if (entityManager == null && factory == null){
			factory = Persistence.createEntityManagerFactory("ordemServico");
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}