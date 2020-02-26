package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "label", length=100, nullable = false, unique = false, insertable = true, updatable = true)
	private String label;
	@Column(name = "quantity", length=100, nullable = false, unique = false, insertable = true, updatable = true)
	private int quantity; 
	@Column(name = "price", length=100, nullable = false, unique = false, insertable = true, updatable = true)
	private float price;
	@ManyToOne(optional = false) 
	@JoinColumn(name = "automate") 
	private Automate automate;
	
	public Article() {
		super();
		this.label = "unkown";
		this.quantity = 1;
		this.price = 1;
	}

	public Article(String label, int quantity,float price) {
		super();
		this.label = label;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Article other = (Article) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
}
