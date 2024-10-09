package com.ward;

public class Ward {
	
	private int wardId;
	private String name;
    private int noOfBeds;
    private String department;
    private String nurseInCharge;
    
    
	public Ward(int wardId, String name, int noOfBeds, String department, String nurseInCharge) {
		
		this.wardId = wardId;
		this.name = name;
		this.noOfBeds = noOfBeds;
		this.department = department;
		this.nurseInCharge = nurseInCharge;
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


	public int getNoOfBeds() {
		return noOfBeds;
	}


	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getNurseInCharge() {
		return nurseInCharge;
	}


	public void setNurseInCharge(String nurseInCharge) {
		this.nurseInCharge = nurseInCharge;
	}
	
	public String toString() {
		return "Ward [id=" + wardId + ", name=" + name + ", noOfBeds=" + noOfBeds + ", department=" + department + ", nurseInCharge=" + nurseInCharge + "]";
	}
	
	
     
}
