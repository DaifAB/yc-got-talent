package com.gotTalent.enums;

public enum EnumConfig {
	DBURL("jdbc:mysql://localhost/youcode_tallent"),
	DBUSERNAME("Sketch"),
	DBPASSWORD("abdel996");
	
	private String label;

	private EnumConfig(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
