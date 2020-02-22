package models;

import java.io.Serializable;
import java.util.List;

public class Machine implements Serializable {
	private static final long serialVersionUID = 1L;
	private StateMachine stateMachine;
	private Float temperature;
	private PaymentSystem paymentSystem[];
	private List<MachineErr> errors;
	
	
	public Machine(StateMachine stateMachine, Float temperature, PaymentSystem paymentSystem[], List<MachineErr> errors) {
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
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
		Machine other = (Machine) obj;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		return true;
	}	
}
