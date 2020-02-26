package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CarteSansContact")
public class CarteSansContact extends PaymentSystem {
	
	public CarteSansContact()
	{
		super();
	}

	public CarteSansContact(String state)
	{
		super(state);
	}
	
	public void setNormal()
	{
		this.state = "Normal";
	}
	
	public void setError()
	{
		this.state = "Error";
	}
	
	@Override
	public String toString() {
		return "CarteSansContact [" + state + "]";
	}

}
