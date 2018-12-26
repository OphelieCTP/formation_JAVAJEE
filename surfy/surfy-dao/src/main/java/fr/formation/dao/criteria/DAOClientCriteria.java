package fr.formation.dao.criteria;


import fr.formation.model.*;

import fr.formation.dao.*;
import fr.formation.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.*;

import java.sql.*;

public class DAOClientCriteria implements IDAOClient {
	
private EntityManager em;
private CriteriaBuilder myCB;
	
	public DAOClientCriteria(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
		this.myCB = emf.getCriteriaBuilder();
	}
	
	
	public List<Client> findAll() {
		CriteriaQuery<Client> myCriteriaQuery = this.myCB.createQuery(Client.class);
		Root<Client> myRootClient = myCriteriaQuery.from(Client.class);
		myCriteriaQuery.select(myRootClient);
		return em.createQuery(myCriteriaQuery).getResultList();
		}

	public Client findById(int id) {
		CriteriaQuery<Client> myCriteriaQuery = this.myCB.createQuery(Client.class);
		Root<Client> myRootClient = myCriteriaQuery.from(Client.class);
		myCriteriaQuery.select(myRootClient).where(myCB.equal(myRootClient.get("id"), id));
		return em.createQuery(myCriteriaQuery).getSingleResult();
	}
	
	public List<Produit> produitsClient(int id){
		CriteriaQuery<Client> myCriteriaQuery = this.myCB.createQuery(Client.class);
		Root <Client> myRootClient = myCriteriaQuery.from(Client.class);
		Join <Client, Commande> myRoot1 = myRootClient.join(Client.class, Commande.class);
		
		// myCriteriaQuery.select(myRootfinal).where(myCB.equal(myRootfinal.get("id"), id));
		return em.createQuery(myCriteriaQuery).getResultList();
		
//		Query myQuery = this.em.createQuery("select p from Produit p inner join fetch p.achat a "
//				+ "left join fetch a.commande cmd "
//				+ "left join fetch cmd.client c "
//				+ "where c.id = :id");
//		return myQuery.getResultList();
	}

	public Client save(Client entity) {
		CriteriaUpdate<Client> update = this.myCB.createCriteriaUpdate(Client.class);
		Root<Client> myRootClient = update.from(Client.class);
		
		if (entity.getId() == 0) {
			em.persist(entity);
		}
		
		else {
			Client client = this.findById(entity.getId());
			// récupérer les champs et voir les différences 
			update.set(Client_.id, value);
			//PRB concernerait qu'un champs
		}
		Query query = em.createQuery(update);
		query.executeUpdate();
		this.em.getTransaction().commit();
		this.em.close();
		return entity;
	}

	public void delete(Client entity) {
		em.remove(em.merge(entity));
	}

	public void deleteById(int id) {
		CriteriaDelete<Client> delete = this.myCB.createCriteriaDelete(Client.class);
		Root<Client> root = delete.from(Client.class);
		Predicate del = this.myCB.equal(root.get("id"), id);
		this.em.createQuery(root.where(delete.)).executeUpdate();
		
		Client myClient = new Client();
		myClient.setId(id);
		this.delete(myClient);
	}
}
