package fr.formation.dao;


import fr.formation.dao.IDAOCommande;

import fr.formation.model.*;

import fr.formation.dao.*;
import fr.formation.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.*;

public class DAOCommandeJPA implements IDAOCommande {
	
private EntityManager em;
	
	public DAOCommandeJPA(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}
	
	
	public List<Commande> findAll() {
		return em
				.createQuery("select c from Commande c", Commande.class)
				.getResultList();
	}

	public Commande findById(int id) {
		return em.find(Commande.class, id);
	}

	public Commande save(Commande entity) {
		em.getTransaction().begin();
		if (entity.getId() == 0) {
			em.persist(entity);
		}
		
		else {
			entity = em.merge(entity);
		}
		em.getTransaction().commit();
		return entity;
	}

	public void delete(Commande entity) {
		em.remove(em.merge(entity));
	}

	public void deleteById(int id) {
		Commande myCommande = new Commande();
		myCommande.setId(id);
		this.delete(myCommande);
	}
	
	public Achat addAchat(Achat a) {
		em.getTransaction().begin();
		if(a.getId()==0) {
			em.persist(a); // considere chaque element relié a sa propre table 
		}
		else {
			a = em.merge(a);
		}
		em.getTransaction().commit();
		return a;
	}
}
