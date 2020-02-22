package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CarteAPuce")
public class CarteAPuce extends PaymentSystem {
	
	public CarteAPuce(String state)
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
}
