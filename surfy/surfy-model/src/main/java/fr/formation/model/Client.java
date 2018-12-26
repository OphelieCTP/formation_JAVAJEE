package fr.formation.model;

import java.util.Date;
import java.util.List;
import fr.formation.model.*;

import javax.persistence.*;

import javax.validation.constraints.*;

//cas du table par class 
@Entity
@Table(name = "client")
@DiscriminatorValue("Client")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="CLI_id")),
	@AttributeOverride(name="nom", column=@Column(name="CLI_nom")),
	@AttributeOverride(name="prenom", column=@Column(name="CLI_prenom")),
	@AttributeOverride(name="adresse", column=@Column(name="CLI_adresse")),
	@AttributeOverride(name="mail", column=@Column(name="CLI_email")),
	@AttributeOverride(name="telephone", column=@Column(name="CLI_telephone"))
})

public class Client extends Personne {
	@Column(name="CLI_DATE_NAISSANCE")
	@Temporal(TemporalType.DATE)
	@NotEmpty
	private Date naissance;
	
	@Column(name="CLI_niveau")
	private int niveau;
	
	@Column(name="CLI_poid")
	private int poid;
	
	@Column(name="CLI_taille")
	private int taille;
	
	@Column(name="CLI_mdp")
	@NotNull
	@Size(max=250)
	private String password;
	

	@ManyToMany(mappedBy="invite")
	private List<Evenement> evenement;
	
	@OneToMany(mappedBy="client")
	private List<Commande> commandes;
	
//	@NamedQueries({
//		@NamedQuery(
//				name="Client.findProduits",
//				query="select p from Produit p inner join fetch p.achat a " + 
//						"inner join fetch a.commande cmd " + 
//						"inner join fetch cmd.client c " + 
//						"where c.id = :id")
//		
//	})
	
	
	public Date getNaissance() {
		return naissance;
	}
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Evenement> getEvenement() {
		return evenement;
	}
	public void setEvenement(List<Evenement> evenement) {
		this.evenement = evenement;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	

}
