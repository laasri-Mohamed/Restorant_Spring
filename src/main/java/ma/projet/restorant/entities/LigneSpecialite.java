package ma.projet.restorant.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneSpecialite {

	@EmbeddedId
	private LigneSpecialitePK specialitePK;
	@ManyToOne
	@JoinColumn(name = "resto_id", insertable = false, updatable = false)
	private Resto restoo;
	@ManyToOne
	@JoinColumn(name = "specialite_id", insertable = false, updatable = false)
	private Specialite specialite;
	
	public LigneSpecialite() {
		super();
	}

	public LigneSpecialitePK getSpecialitePK() {
		return specialitePK;
	}

	public void setSpecialitePK(LigneSpecialitePK specialitePK) {
		this.specialitePK = specialitePK;
	}

	public Resto getResto() {
		return restoo;
	}

	public void setResto(Resto resto) {
		this.restoo = resto;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
}
