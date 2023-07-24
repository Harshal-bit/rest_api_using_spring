package com.harshal.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {
	
	private String firstName,lastname;
	public PersonV2() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastname() {
		return lastname;
	}
	@Override
	public String toString() {
		return "PersonV2 [firstName=" + firstName + ", lastname=" + lastname + "]";
	}
	public PersonV2(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}

}
