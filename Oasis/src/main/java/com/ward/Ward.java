package com.ward;

public class Ward {

	private int wardId;
	private String name;
	private int numberOfBeds;
	private String department;
	
	public Ward() {}

	public Ward(int wardId, String name, int numberOfBeds, String department) {
		
		this.wardId = wardId;
		this.name = name;
		this.numberOfBeds = numberOfBeds;
		this.department = department;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
	
}
