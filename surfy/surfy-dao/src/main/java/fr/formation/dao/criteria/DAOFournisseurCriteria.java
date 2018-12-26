package fr.formation.dao.criteria;


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

public class DAOFournisseurCriteria implements IDAOFournisseur {
	
private EntityManager em;
private CriteriaBuilder myCB;
	
	public DAOFournisseurCriteria(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
		this.myCB = emf.getCriteriaBuilder();
	}
	
	
	public List<Fournisseur> findAll() {
		CriteriaQuery<Fournisseur> myCriteriaQuery = this.myCB.createQuery(Fournisseur.class);
		Root<Fournisseur> myRootFournisseur = myCriteriaQuery.from(Fournisseur.class);
		myCriteriaQuery.select(myRootFournisseur);
		return em.createQuery(myCriteriaQuery).getResultList();
		}

	public Fournisseur findById(int id) {
		CriteriaQuery<Fournisseur> myCriteriaQuery = this.myCB.createQuery(Fournisseur.class);
		Root<Fournisseur> myRootFournisseur = myCriteriaQuery.from(Fournisseur.class);
		myCriteriaQuery.select(myRootFournisseur).where(myCB.equal(myRootFournisseur.get("id"), id));
		return em.createQuery(myCriteriaQuery).getSingleResult();
	}

	public Fournisseur save(Fournisseur entity) {
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

	public void delete(Fournisseur entity) {
		em.remove(em.merge(entity));
	}

	public void deleteById(int id) {
		Fournisseur myFournisseur = new Fournisseur();
		myFournisseur.setId(id);
		this.delete(myFournisseur);
	}
}
