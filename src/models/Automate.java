package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Automate implements Serializable {
		
	private static final long serialVersionUID = 1L;
	private String serialNumber;
	private ArticlesType articlesType;
	private Address address;
	private String area; //which area it is at
	private Gps gpsCoordinates;
	private StateAutomate stateAutomate;
	private String comments;
	
	
	public String getSerialNumber() {
		return serialNumber; 
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public ArticlesType getArticlesType() {
		return articlesType;
	}
	public void setArticlesType(ArticlesType articlesType) {
		this.articlesType = articlesType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Gps getGpsCoordinates() {
		return gpsCoordinates;
	}
	public void setGpsCoordinates(Gps gpsCoordinates) {
		this.gpsCoordinates = gpsCoordinates;
	}
	public StateAutomate getStateAutomate() {
		return stateAutomate;
	}
	public void setStateAutomate(StateAutomate stateAutomate) {
		this.stateAutomate = stateAutomate;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
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
		Automate other = (Automate) obj;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Automate [serialNumber=" + serialNumber + ", articlesType=" + articlesType + ", address=" + address
				+ ", area=" + area + ", gpsCoordinates=" + gpsCoordinates + ", stateAutomate=" + stateAutomate
				+ ", comments=" + comments + "]";
	}
	
}
