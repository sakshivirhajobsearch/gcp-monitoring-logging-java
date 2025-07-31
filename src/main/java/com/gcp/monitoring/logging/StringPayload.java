package com.gcp.monitoring.logging;

public class StringPayload {
	
	private String value;

	public StringPayload(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static StringPayload of(String value) {
		return new StringPayload(value);
	}
}
