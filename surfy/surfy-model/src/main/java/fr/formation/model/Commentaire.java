package fr.formation.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "commentaire")

public class Commentaire {
	@Id
	@Column(name="COMT_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Column(name="COMT_produit_id", nullable=false)
//	@OneToOne(mappedBy="produit")
//	private int idProduit;
//	
//	@Column(name="COMT_evenement_id", nullable=false)
//	@OneToOne(mappedBy="evenement")
//	private int idEvenement;
//	
//	@Column(name="COMT_client_id", nullable=false)
//	@OneToMany(mappedBy="client")
//	private int idClient;
	
	@Column(name="COMT_note", nullable=false)
	private int note;
	
	@Column(name="COMT_commentaire", columnDefinition = "TEXT", nullable=false)
	@Lob
	private String commentaire;
	@Column(name="COMT_photo", columnDefinition = "TEXT", nullable=false)
	@Lob
	private String photo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getIdProduit() {
//		return idProduit;
//	}
//	public void setIdProduit(int idProduit) {
//		this.idProduit = idProduit;
//	}
//	public int getIdEvenement() {
//		return idEvenement;
//	}
//	public void setIdEvenement(int idEvenement) {
//		this.idEvenement = idEvenement;
//	}
//	public int getIdClient() {
//		return idClient;
//	}
//	public void setIdClient(int idClient) {
//		this.idClient = idClient;
//	}
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
