package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "machine")
public class Machine implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Enumerated(EnumType.STRING)
	private StateMachine stateMachine;
	@Column(name = "temperature", length=50, nullable = false, unique = false, insertable = true, updatable = true)
	private float temperature;
    @OneToMany(mappedBy = "id", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private PaymentSystem paymentSystem[];
    @OneToMany(mappedBy = "id", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<MachineErr> errors;
	
	
	public Machine(StateMachine stateMachine, float temperature, PaymentSystem paymentSystem[], List<MachineErr> errors) {
		this.stateMachine = stateMachine;
		this.temperature = temperature;
		this.paymentSystem = paymentSystem;
		this.errors = errors;
	}
	
	public StateMachine getStateMachine() {
		return stateMachine;
	}
	public void setStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public PaymentSystem[] getPaymentSystem() {
		return paymentSystem;
	}
	public void setPaymentSystem(PaymentSystem paymentSystem[]) {
		this.paymentSystem = paymentSystem;
	}
	public List<MachineErr> getErrors() {
		return errors;
	}
	public void setErrors(List<MachineErr> errors) {
		this.errors = errors;
	}

}
