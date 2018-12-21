package fr.formation.dao;


import fr.formation.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.*;

public class DAOProduitJPA implements IDAOProduit {
	
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	

	public void configureEm() {
		this.em = createEntityManagerFactory().createEntityManager();
	}
	
	public EntityManagerFactory createEntityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SurfyPU");
		return emf;
	}

	public List<Produit> findAll() {
		List<Produit> myProduits = this.em.createQuery("SELECT p FROM Produit p ", Produit.class).getResultList();
		return myProduits;
	}

	public Produit findById(int id) {
		List<Produit> allProduits = this.findAll();
		for (Produit prod : allProduits) {
			if(prod.getId()==id) {
				return prod;
			}
		}
		return null;
	}

	public Produit save(Produit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Produit entity) {
		this.em.remove(entity);		
	}

	public void deleteById(int id) {
		List<Produit> allProduits = this.findAll();
		for (Produit prod : allProduits) {
			if(prod.getId()==id) {
				this.delete(prod);
			}
		}
	}
	

}
