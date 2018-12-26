package fr.formation.dao.criteria;


import fr.formation.dao.*;

import fr.formation.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

import java.sql.*;

// https://docs.oracle.com/javaee/6/tutorial/doc/gjivm.html

public class DAOProduitCriteria implements IDAOProduit {
	private EntityManager em;
	private CriteriaBuilder myCB;
	
	
	public DAOProduitCriteria(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
		this.myCB = emf.getCriteriaBuilder();
	}
	
	
	@Override
	public List<Produit> findAll() {
		CriteriaQuery<Produit> myCriteriaQuery = this.myCB.createQuery(Produit.class);
		Root<Produit> myRootProduit = myCriteriaQuery.from(Produit.class);
		myCriteriaQuery.select(myRootProduit);
		return em.createQuery(myCriteriaQuery).getResultList();
	}

	@Override
	public Produit findById(int id) {
		CriteriaQuery<Produit> myCriteriaQuery = this.myCB.createQuery(Produit.class);
		Root<Produit> myRootProduit = myCriteriaQuery.from(Produit.class);
		myCriteriaQuery.select(myRootProduit).where(myCB.equal(myRootProduit.get("id"), id));
		
		return em.createQuery(myCriteriaQuery).getSingleResult();
	}

	@Override
	public Produit save(Produit entity) {
		CriteriaQuery<Produit> myCriteriaQuery = this.myCB.createQuery(Produit.class);
		Root<Produit> myRootProduit = myCriteriaQuery.from(Produit.class);
		
		
		//On démarre la transaction
		em.getTransaction().begin();
		
		if (entity.getId() == 0) {
			em.persist(entity);
		}
		
		else {
			entity = em.merge(entity);
		}
		
		//On commit la transaction
		em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public void delete(Produit entity) {
		em.remove(em.merge(entity));
	}

	@Override
	public void deleteById(int id) {
		Produit myProduit = new Produit();
		myProduit.setId(id);
		this.delete(myProduit);
	}
}
