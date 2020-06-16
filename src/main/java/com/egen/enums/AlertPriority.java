package com.egen.enums;

public enum AlertPriority {

	HIGH("HIGH"),MEDIUM("MEDIUM"),LOW("LOW");
	
	private final String priority;

	private AlertPriority(String priority) {
		this.priority = priority;
	}

	public String getPriority() {
		return priority;
	}

}
