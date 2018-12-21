package fr.formation;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "evenement")

public class Evenement {
	@Id
	@Column(name="EVE_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="EVE_nom")
	private String nom;
	
	
	@ManyToMany
	@JoinTable(
			name="participation", // nom de la table relationnelle de correspondance
			uniqueConstraints=@UniqueConstraint(columnNames = { "PARTICIPATION_EVENEMENT_ID", "PARTICIPATION_CLIENT_ID" }),
			joinColumns=@JoinColumn(name="PARTICIPATION_EVENEMENT_ID", referencedColumnName="EVE_id"),
			inverseJoinColumns =@JoinColumn(name="PARTICIPATION_CLIENT_ID", referencedColumnName="CLI_id")
			)
	private List<Client> invite;
	
	
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
	public List<Client> getInvite() {
		return invite;
	}
	public void setInvite(List<Client> invite) {
		this.invite = invite;
	}
	
	

}
