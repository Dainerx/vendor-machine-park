/**
 * 
 */
package models;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author 
 *
 */
@Entity(name="payment_system")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="payment_system_type", 
discriminatorType = DiscriminatorType.STRING)
public class PaymentSystem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	protected int id;
	@Column(name = "state", nullable = false)
	protected String state;
	public PaymentSystem(String state) {
		this.state = state;
	}
	
	protected String getState()
	{
		return this.state;
	}

}
