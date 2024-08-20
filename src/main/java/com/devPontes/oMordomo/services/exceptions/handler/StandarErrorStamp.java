package com.devPontes.oMordomo.services.exceptions.handler;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class StandarErrorStamp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String details;
	private Date timestamp;
	private String message;
	
	public StandarErrorStamp(String details, Date timestamp, String message) {
		this.details = details;
		this.timestamp = timestamp;
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, message, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StandarErrorStamp other = (StandarErrorStamp) obj;
		return Objects.equals(details, other.details) && Objects.equals(message, other.message)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "StandarErrorStamp [details=" + details + ", timestamp=" + timestamp + ", message=" + message + "]";
	}
	
	
	
	
}
