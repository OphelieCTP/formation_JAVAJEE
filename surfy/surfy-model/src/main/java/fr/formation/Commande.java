package fr.formation;

import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "commande")

public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int idClient;
	
	@Column(name="COMD_date", length=150, nullable=false)
	@Temporal(TemporalType.DATE)
	@NotEmpty
	@NotNull
	private Date date;
	private Double prixTotal;
	private String transporteur;
	private int etat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}
	public String getTransporteur() {
		return transporteur;
	}
	public void setTransporteur(String transporteur) {
		this.transporteur = transporteur;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	

}
