package fr.formation.model;

import java.util.Date;
import java.util.List;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "commande")

public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="COMD_client_id")
	private int idClient;
	
	@Column(name="COMD_date", length=150, nullable=false)
	@Temporal(TemporalType.DATE)
	@NotEmpty
	private Date date;
	
	@Column(name="COMD_prixtotal", nullable=false)
	@Positive
	private Double prixTotal;
	
	@Column(name="COMD_transporteur", nullable=false)
	@NotEmpty
	@Size(max=50)
	private String transporteur;
	
	@Column(name="COMD_etat")
	private int etat;
	
	@OneToMany(mappedBy="commande", cascade = CascadeType.PERSIST)
	private List <Achat> produitsAchetes ;
	
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
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
	public List<Achat> getProduitsAchetes() {
		return produitsAchetes;
	}
	public void setProduitsAchetes(List<Achat> produitsAchetes) {
		this.produitsAchetes = produitsAchetes;
	}
	

}
