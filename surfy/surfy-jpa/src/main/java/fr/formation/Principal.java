package fr.formation;

import fr.formation.*;
import fr.formation.dao.DAOProduitJPA;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

public class Principal {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SurfyPU");
		EntityManager em = emf.createEntityManager();
		IDAOProduit daoProduit = new DAOProduitJPA(emf);
		
		List<Produit> myProduits = em.createQuery("SELECT p FROM Produit p ", Produit.class).getResultList();
		
		for (Produit p : myProduits) {
			System.out.println("-------------------");
			System.out.println(p.getModele()+" : "+p.getDescription());
		}
		
		Produit entity = new Produit();
		entity.setModele("Une planche");
		entity.setDescription("un article");
		entity.setDisponibilite(50);
		entity.setPrix(155.20d);
		
		em.persist(entity);
		
		
		em.close();
		emf.close();
		
//		EntityTransaction tx = em.getTransaction(); //Récupérer la transaction
//		tx.begin(); //Démarrer la transaction
//		tx.commit(); //Appliquer les traitements en base de données
//		tx.rollback(); //Annuler les traitements
		
		// faire liste de sproduits avec la DAO et ajouter un nouveau produit avec la DAO et un fournisseur 
		
	}

}
