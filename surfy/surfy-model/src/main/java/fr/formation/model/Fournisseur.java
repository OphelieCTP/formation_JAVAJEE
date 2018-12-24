package fr.formation.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


import javax.persistence.*;
import javax.validation.constraints.*;
// Joined 
@Entity
@Table(name = "fournisseur")
@DiscriminatorValue("Fournisseur")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="FOU_id")),
	@AttributeOverride(name="nom", column=@Column(name="FOU_nom")),
	@AttributeOverride(name="adresse", column=@Column(name="FOU_adresse")),
	@AttributeOverride(name="mail", column=@Column(name="FOU_mail")),
	@AttributeOverride(name="telephone", column=@Column(name="FOU_telephone"))
})

public class Fournisseur extends Personne {	
	
	@OneToMany(mappedBy="fournisseur")
	private List<Produit> produits;

	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
}
