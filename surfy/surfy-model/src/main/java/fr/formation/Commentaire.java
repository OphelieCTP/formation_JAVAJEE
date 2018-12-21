package fr.formation;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "commentaire")

public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int idProduit;
	private int idEvenement;
	private int idClient;
	private int note;
	private String commentaire;
	private String photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdEvenement() {
		return idEvenement;
	}
	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	

}
