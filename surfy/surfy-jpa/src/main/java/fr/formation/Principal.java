package fr.formation;

import javax.persistence.*;
import javax.persistence.criteria.*;

import fr.formation.dao.*;
import fr.formation.dao.criteria.*;
import fr.formation.model.*;
import java.util.List;

public class Principal {
	public static void main(String[] args) { //listing : liste des produits, fournisseurs, clients 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SurfyPU");
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder myCB = emf.getCriteriaBuilder();
		
		IDAOProduit daoProduit = new DAOProduitCriteria(emf);
		IDAOClient daoClient = new DAOClientCriteria(emf);
		IDAOFournisseur daoFournisseur = new DAOFournisseurCriteria(emf);
		
		List<Produit> produits = daoProduit.findAll();
		System.out.println("Test Criteria : list produits ");
		for (Produit p : produits) {
			System.out.println("-------------------");
			System.out.println(p.getModele()+" : "+p.getDescription());
		}
		
		List<Client> clients = daoClient.findAll();
		System.out.println("Test Criteria : list clients ");
		for (Client c : clients) {
			System.out.println("-------------------");
			System.out.println(c.getNom()+" : "+c.getPrenom());
		}
		
		List<Fournisseur> fournisseurs = daoFournisseur.findAll();
		System.out.println("Test Criteria : list clients ");
		for (Fournisseur f : fournisseurs) {
			System.out.println("-------------------");
			System.out.println(f.getNom());
		}
		
		List<Produit> produitsclient = daoClient.produitsClient(1);
		
		// produit client soit part DAO client et join de tt ou part produit et recup tt via achat
		
		//for(Commande c : find..args.)
		
		em.close();
		emf.close();
		
	}
	

}
