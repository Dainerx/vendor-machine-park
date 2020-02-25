package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name="id")
	private Set<PaymentSystem> paymentSystem = new HashSet<>();
	
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
    @JoinColumn(name="id")
    private Set<MachineErr> errors = new HashSet<>();
	
	
	public Machine() {
		this.stateMachine = StateMachine.OK;
		this.temperature = 37f;
		this.paymentSystem = new HashSet<>();;
		this.errors = new HashSet<>();
	}

	public Machine(StateMachine stateMachine, float temperature, Set<PaymentSystem> paymentSystem, Set<MachineErr> errors) {
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
	public Set<PaymentSystem> getPaymentSystem() {
		return paymentSystem;
	}
	public void addPaymentSystem(PaymentSystem paymentSystem) {
		this.paymentSystem.add(paymentSystem);
	}
	public Set<MachineErr>  getErrors() {
		return errors;
	}
	public void addErrors(MachineErr error) {
		this.errors.add(error);
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", stateMachine=" + stateMachine + ", temperature=" + temperature
				+ ", paymentSystem=" + paymentSystem + ", errors=" + errors + "]";
	}

}
