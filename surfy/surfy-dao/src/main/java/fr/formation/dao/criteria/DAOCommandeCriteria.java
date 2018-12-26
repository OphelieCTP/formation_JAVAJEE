package fr.formation.dao.criteria;


import fr.formation.dao.IDAOCommande;

import fr.formation.model.*;

import fr.formation.dao.*;
import fr.formation.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.sql.*;

public class DAOCommandeCriteria implements IDAOCommande {
	
private EntityManager em;
private CriteriaBuilder myCB;
	
	public DAOCommandeCriteria(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
		this.myCB = emf.getCriteriaBuilder();
	}
	
	
	public List<Commande> findAll() {
		CriteriaQuery<Commande> myCriteriaQuery = this.myCB.createQuery(Commande.class);
		Root<Commande> myRootCommande = myCriteriaQuery.from(Commande.class);
		myCriteriaQuery.select(myRootCommande);
		return em.createQuery(myCriteriaQuery).getResultList();
		}

	public Commande findById(int id) {
		CriteriaQuery<Commande> myCriteriaQuery = this.myCB.createQuery(Commande.class);
		Root<Commande> myRootCommande = myCriteriaQuery.from(Commande.class);
		myCriteriaQuery.select(myRootCommande).where(myCB.equal(myRootCommande.get("id"), id));
		return em.createQuery(myCriteriaQuery).getSingleResult();
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
