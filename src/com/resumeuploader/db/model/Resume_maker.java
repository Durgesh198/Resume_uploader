package com.resumeuploader.db.model;

public class Resume_maker {
	
	private int id;
	private String name;
	private String email;
	private String contact;
	private String address;
	private String job_location;
	private String experience;
	private String qualification;
	private String job_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJob_location() {
		return job_location;
	}
	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	@Override
	public String toString() {
		
		return "\n\nId: " + id + ", \nName: " + name + ", \nEmail: " + email + ", \nContact: " + contact + ", \nAddress: "
				+ address + ", \nJob Location: " + job_location + ", \nExperience: " + experience + ", \nQualification: "
				+ qualification + ", \nJob Type: " + job_type + "\n\n";
		
	}
	
	
	
	

}
