package com.curso.otras;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCATIONS_LOCATIONID_GENERATOR", sequenceName="LOCATION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATIONS_LOCATIONID_GENERATOR")
	@Column(name="LOCATION_ID")
	private long locationId;

	private String city;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	//bi-directional many-to-one association to Pais
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COUNTRY_ID")
	private Pais country;

	public Localidad() {
	}

	public long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Pais getCountry() {
		return this.country;
	}

	public void setCountry(Pais country) {
		this.country = country;
	}

}