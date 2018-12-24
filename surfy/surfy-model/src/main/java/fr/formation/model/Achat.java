package fr.formation.model;

import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "achat")

public class Achat {
	@Id
	@Column(name="ACH_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ACH_commande_id")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="ACH_produit_id")
	private Produit produit;
	
	
	@Column(name="ACH_prix_unit", nullable=false)
	@Positive
	private Double prixUnit;
	
	@Column(name="ACH_quantite", nullable=false)
	@Positive
	@NotEmpty
	private int quantite;
	
	@Column(name="ACH_remarque", columnDefinition = "TEXT", nullable=false)
	@Lob
	private String remarque;
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
		
	
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPrixUnit() {
		return prixUnit;
	}
	public void setPrixUnit(Double prixUnit) {
		this.prixUnit = prixUnit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
	


}
