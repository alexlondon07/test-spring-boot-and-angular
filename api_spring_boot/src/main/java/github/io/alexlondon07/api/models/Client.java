package github.io.alexlondon07.api.models;

import java.io.Serializable;


public class Client implements Serializable {
	
	private static final long serialVersionUID = 1682943283826480346L;
	private String firstname;
	private String lastname;
	private String identification;
	private String birthdate;

	//Constructors
	public Client() {
		super();
	}

	public Client(String firstname, String lastname, String identification, String birthdate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.identification = identification;
		this.birthdate = birthdate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Client [firstname=" + firstname + ", lastname=" + lastname + ", identification=" + identification
				+ ", birthdate=" + birthdate + "]";
	}
	 
}
