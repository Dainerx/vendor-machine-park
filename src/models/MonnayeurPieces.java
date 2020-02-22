package models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MonnayeurPieces")
public class MonnayeurPieces extends PaymentSystem {
	
	public MonnayeurPieces(String state)
	{
		super(state);
	}
	
	public void setNormal()
	{
		this.state = "Normal";
	}
	
	public void setPlein()
	{
		this.state = "Plein";
	}
	
	public void setVide()
	{
		this.state = "Vide";
	}
}
