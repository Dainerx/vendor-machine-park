package models;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "street_number", nullable = false, unique = false, insertable = true, updatable = true)
	private int streetNumber;
	@Column(name = "street", length=100, nullable = false, unique = false, insertable = true, updatable = true)
	private String street;
	@Column(name = "city", length=50, nullable = false, unique = false, insertable = true, updatable = true)
	private String city;
	@Column(name = "post_code", length=50, nullable = false, unique = false, insertable = true, updatable = true)
	private int postCode;
	
	public Address() {
		this.streetNumber = 0;
		this.street  = "no street";
		this.city = "no city";
		this.postCode = 0; 
	}
	public Address(int streetNumber, 
			String street, String city, int postCode)
	{
		this.streetNumber = streetNumber;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
	}
	
	public void setAddress(int streetNumber, 
			String street, String city, int postCode) {
		this.streetNumber = streetNumber;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public int getPostCode() {
		return postCode;
	}

	@Override
	public String toString() {
		return "Address [streetNumber=" + streetNumber + ", street=" + street + ", city=" + city + ", postCode="
				+ postCode + "]";
	}

	
}
