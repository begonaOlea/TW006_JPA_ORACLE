package com.curso.otras;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the REGIONS database table.
 * 
 */
@Entity
@Table(name="REGIONS")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID")
	private long regionId;

	@Column(name="REGION_NAME")
	private String regionName;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="region",fetch = FetchType.EAGER) //LAZY
	private List<Pais> countries;

	public Region() {
	}

	public long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<Pais> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Pais> countries) {
		this.countries = countries;
	}

	public Pais addCountry(Pais country) {
		getCountries().add(country);
		country.setRegion(this);

		return country;
	}

	public Pais removeCountry(Pais country) {
		getCountries().remove(country);
		country.setRegion(null);

		return country;
	}

}