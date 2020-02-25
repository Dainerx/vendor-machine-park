package models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "automate")
public class Automate implements Serializable {
		
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "serial_number", nullable = false)
	private String serialNumber;
    @JoinColumn(name = "machine", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
	private Machine machine;
	@Enumerated(EnumType.STRING)
	private ArticlesType articlesType;
	@Embedded	 
	private Address address;
	@Column(name = "area", length=100, nullable = true, unique = false, insertable = true, updatable = true)
	private String area; //which area it is at
	@Embedded	 
	private Gps gpsCoordinates;
	@Enumerated(EnumType.STRING)
	private StateAutomate stateAutomate;
	@Column(name = "comments", length=1000, nullable = true, unique = false, insertable = true, updatable = true)
	private String comments;
	
	public String getSerialNumber() {
		return serialNumber; 
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
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
		return "Automate [machine=" + machine + ", serialNumber=" + serialNumber + ", articlesType=" + articlesType
				+ ", address=" + address + ", area=" + area + ", gpsCoordinates=" + gpsCoordinates + ", stateAutomate="
				+ stateAutomate + ", comments=" + comments + "]";
	}

	
}
