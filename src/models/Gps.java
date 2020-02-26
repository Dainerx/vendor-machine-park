package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Gps implements Serializable {
	@Column(name = "latitude", length=100, nullable = false, unique = false, insertable = true, updatable = true)
	private float latitude;
	@Column(name = "longitude", length=100, nullable = false, unique = false, insertable = true, updatable = true)
	private float longitude;	

	public Gps() {
		this.latitude = 0;
		this.longitude = 0;
	}
	public Gps(float latitude, float longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gps other = (Gps) obj;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "(" + latitude + "," + longitude + ")";
	}
	
	

}
