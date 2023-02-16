package ma.projet.restorant.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Resto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom, adresse;
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm")
	private Date openTime, closeTime;
	private double height, width;
	private double rank;
	private boolean week;
	@ManyToOne
	private Zone zone;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "resto")
	@JsonIgnore
	private List<Photo> photos;
	@ManyToOne
	private Serie serie;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "restoo")
	private List<LigneSpecialite> ligneSpecialite;

	public Resto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public boolean isWeek() {
		return week;
	}

	public void setWeek(boolean week) {
		this.week = week;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<LigneSpecialite> getSpecs() {
		return ligneSpecialite;
	}

	public void setSpecs(List<LigneSpecialite> ligneSpecialite) {
		this.ligneSpecialite = ligneSpecialite;
	}

}