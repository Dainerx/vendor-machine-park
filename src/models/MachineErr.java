/**
 * 
 */
package models;
import java.util.Date;
/**
 * @author 
 *
 */
public class MachineErr {

	private String message;
	private Date timestamp;
	
	public MachineErr(String message, Date timestamp) {
		super();
		this.message = message;
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		MachineErr other = (MachineErr) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MachineErr [message=" + message + ", getMessage()=" + getMessage() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	

}
