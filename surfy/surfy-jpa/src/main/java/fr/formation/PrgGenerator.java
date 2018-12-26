package fr.formation;

import fr.formation.dao.*;
import fr.formation.model.*;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

public class PrgGenerator {
	//création, génération d'objets et d'infos 
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SurfyPU");
		EntityManager em = emf.createEntityManager();
		IDAOProduit daoProduit = new DAOProduitJPA(emf);
		IDAOCommande daoCommande = new DAOCommandeJPA(emf);
		
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
		
		
		Commande c = new Commande();
		Client cli = new Client();
		Produit p1 = new Produit();
		p1.setModele("Une nouvelle plance");
		p1.setDescription("un nouvel article");
		p1.setDisponibilite(60);
		p1.setPrix(200.20d);
		Produit p2 = new Produit();
		p1.setModele("Une nouvelle nouvelle plance");
		p1.setDescription("un nouvel nouvel article");
		p1.setDisponibilite(60);
		p1.setPrix(200.20d);
		Achat a1 = new Achat();
		Achat a2 = new Achat();

		// asso 1 achat avec les produit		
		a1.setProduit(p1);
		a2.setProduit(p2);
		
		//assoc Client avec commande
		c.setClient(cli);
		
		//asso achat avec commande
		c.ajouterProduit(p1, 5);
		c.ajouterProduit(p2, 10);
		
		// on choisit client et produits
		cli.setId(1); //client1
		p1.setId(3); // produit 3
		p1.setId(1); //produit 1
		c.setDate(new Date());
		c.setTransporteur("les Demenageurs Bretons");
		c.setPrixTotal(200.20d);
		daoCommande.save(c);
		
		
		
		

		em.close();
		emf.close();
		
		

	}

}
