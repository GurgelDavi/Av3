package com.davi.av3.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ResoursePersistence{
	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("Av3");
	
	public static EntityManager getEntityManager() {
			return emf.createEntityManager();
		}


}

