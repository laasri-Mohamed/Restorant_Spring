package ma.projet.restorant.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class LigneSpecialitePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int resto_id;
	private int specialite_id;

	public LigneSpecialitePK() {
		super();
	}

	public int getResto_id() {
		return resto_id;
	}

	public void setResto_id(int resto_id) {
		this.resto_id = resto_id;
	}

	public int getSpecialite_id() {
		return specialite_id;
	}

	public void setSpecialite_id(int specialite_id) {
		this.specialite_id = specialite_id;
	}

}
