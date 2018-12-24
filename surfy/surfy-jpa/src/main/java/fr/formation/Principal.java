package fr.formation;

import fr.formation.dao.*;
import fr.formation.model.*;

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
		
		Commande c = new Commande();
		Client cli = new Client();
		Produit p1 = new Produit();
		Produit p2 = new Produit();
		Achat a1 = new Achat();
		Achat a2 = new Achat();
		
		// asso 1 achat avec les produit
		
		a1.setProduit(p1);
		a2.setProduit(p2);
		
		//assoc Client avec commande
		c.setClient(cli);
		
		//asso achat avec commande
		c.setProduitsAchetes(new ArrayList<Achat>());
		c.getProduitsAchetes().add(a1);
		c.getProduitsAchetes().add(a2);
		
		// 
		a1.setCommande(c);
		a2.setCommande(c);
		
		// on choisit client et produits
		cli.setId(1); //client1
		p1.setId(3); // produit 3
		p1.setId(1); //produit 1
		
//		EntityTransaction tx = em.getTransaction(); //Récupérer la transaction
//		tx.begin(); //Démarrer la transaction
//		tx.commit(); //Appliquer les traitements en base de données
//		tx.rollback(); //Annuler les traitements
		
		// faire liste de sproduits avec la DAO et ajouter un nouveau produit avec la DAO et un fournisseur 
		
	}

}
