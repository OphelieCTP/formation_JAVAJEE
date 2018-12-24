package fr.formation.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "produit")

public class Produit {
	@Id
	@Column(name="PRO_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PRO_cat")
	@NotEmpty
	private int categorie;
	
	@Column(name="PRO_type")
	@NotEmpty
	private int type;
	
	@Column(name="PRO_modele", nullable=false)
	@NotEmpty
	@NotNull
	private String modele;
	
	@Column(name="PRO_taille", nullable=false)
	@Positive
	private int taille;
	
	@Column(name="PRO_prix", nullable=false)
	@Positive
	private Double prix;
	
	@Column(name="PRO_dispo")
	private int disponibilite;
	
	@Column(name="PRO_photo" )
	private String photo;
	
	@Column(name="PRO_description", columnDefinition = "TEXT")
	@Lob
	private String description;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "PRO_fournisseur_id")
	private Fournisseur fournisseur;	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(int disponibilite) {
		this.disponibilite = disponibilite;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
}
