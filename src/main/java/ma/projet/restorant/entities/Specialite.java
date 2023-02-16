package ma.projet.restorant.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "specialite")
	private List<LigneSpecialite> ligneSpecialite;

	public Specialite() {
		super();
	}

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

	public List<LigneSpecialite> getRestos() {
		return ligneSpecialite;
	}

	public void setRestos(List<LigneSpecialite> ligneSpecialite) {
		this.ligneSpecialite = ligneSpecialite;
	}

}
