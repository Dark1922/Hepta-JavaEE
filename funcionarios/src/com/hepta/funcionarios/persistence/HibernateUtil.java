package com.hepta.funcionarios.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static final String PERSISTENCE_UNIT_NAME = "funcionarios-bd";
	
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			createEntityManagerFactory();
		}
		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
	
	public static void createEntityManagerFactory(){
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public static EntityManager getEntityManager(){
		return HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
	
	public static void main(String[] args) {
		HibernateUtil.getEntityManagerFactory().createEntityManager();
		HibernateUtil.shutdown();
	}
}
