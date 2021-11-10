package com.curso.otras;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COUNTRIES database table.
 * 
 */
@Entity
@Table(name="COUNTRIES")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COUNTRY_ID")
	private String countryId;

	@Column(name="COUNTRY_NAME")
	private String countryName;


	@Column(name="REGION_ID")
	private long idRegion;
	
	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="REGION_ID", 
					insertable = false,
					updatable = false)
	private Region region;
	
	

	//bi-directional many-to-one association to Localidad
	@OneToMany(mappedBy="country", fetch = FetchType.EAGER) //LAZY
	private List<Localidad> locations;

	public Pais() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Localidad> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Localidad> locations) {
		this.locations = locations;
	}
	
	public long getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(long idRegion) {
		this.idRegion = idRegion;
	}

	public Localidad addLocation(Localidad location) {
		getLocations().add(location);
		location.setCountry(this);

		return location;
	}

	public Localidad removeLocation(Localidad location) {
		getLocations().remove(location);
		location.setCountry(null);

		return location;
	}

}