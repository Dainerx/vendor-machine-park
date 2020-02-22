package models;

public class CarteSansContact extends PaymentSystem {
	
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
}
