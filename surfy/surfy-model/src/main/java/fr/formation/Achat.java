package fr.formation;

import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "achat")

// table joined : 
//@PrimaryKeyJoinColumn(name="CLI_ID", referencedColumnName="PER_ID")

public class Achat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int idCommande;
	private int idProduit;
	private Double prixUnit;
	private int quantite;
	private String remarque;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
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
