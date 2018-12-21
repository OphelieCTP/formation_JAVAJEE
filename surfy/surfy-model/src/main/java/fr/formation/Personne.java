package fr.formation;

import javax.persistence.*;
import javax.validation.constraints.*;

@MappedSuperclass
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@NotNull
	@Size(max=100)
	private String nom;
	
	@NotEmpty
	@NotNull
	@Size(max=100)
	private String prenom;
	
	@NotEmpty
	@NotNull
	@Size(max=250)
	private String adresse;
	
	@NotEmpty
	@NotNull
	@Size(max=150)
	private String telephone;
	
	@NotEmpty
	@NotNull
	@Size(max=100)
	private String mail;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
