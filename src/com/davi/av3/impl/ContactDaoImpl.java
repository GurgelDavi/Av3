package com.davi.av3.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.postgresql.util.LruCache.CreateAction;

import com.davi.av3.controller.ResoursePersistence;
import com.davi.av3.model.Contact;

public class ContactDaoImpl {
	public void create(Contact obj) {
		// TODO Auto-generated method stub
		EntityManager em = ResoursePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			System.out.println("Inserido " + obj.getName());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public void remove(Contact obj) {
		EntityManager em = ResoursePersistence.getEntityManager();
		Contact c ;
		try {
			em.getTransaction().begin();
			c= em.merge(obj);
			em.remove(c);
			em.getTransaction().commit();
			System.out.println("removido "+obj.getName());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		}finally {
			em.close();
		}
	}

	public void alter(Contact obj) {
		EntityManager em = ResoursePersistence.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			System.out.println("Alterado "+obj.getName());
		} catch (Exception e) {
			System.err.println("erro " + e.getMessage());
		}finally {
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List getAllContacts(Contact obj) {
		EntityManager em = ResoursePersistence.getEntityManager();
		List<Contact> contatos = new ArrayList<Contact>();
		try {
			em.getTransaction().begin();
			contatos = em.createQuery("SELECT c FROM Contato c").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
		return contatos;
	}
	
}
