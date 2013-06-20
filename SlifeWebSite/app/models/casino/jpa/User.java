package models.casino.jpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class User extends Model {

	public String firstName;
	
	public String lastName;
	
	public String email;
	
	public String dateOfBirth;
	
	public String address;

	public String pwHash;

	public String confirmationCode;

	public String recoverPasswordCode;



	private ArrayList<String> roles;
	

	public User(String firstName, String lastName, String email,String dateOfBirth, String address, String passwordHash, String confirmationCode) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.pwHash = passwordHash;
		this.confirmationCode = confirmationCode;

		this.roles = new ArrayList<String>();
	}


	public boolean hasRole(String role) {
		
		HashSet<String> rolesSet = new HashSet<String>(getRoles());

		return rolesSet.contains(role);

	}

	public void addRole(String role) {

		HashSet<String> rolesSet = new HashSet<String>(getRoles());
		rolesSet.add(role);

		getRoles().clear();
		getRoles().addAll(new  ArrayList<String>(rolesSet));
		

	}

	public void removeRole(String role) {

		HashSet<String> rolesSet = new HashSet<String>(getRoles());
		rolesSet.remove(role);

		getRoles().clear();
		getRoles().addAll(new  ArrayList<String>(rolesSet));

	}
	
	private List<String> getRoles() {
	
		if (roles == null) {
			roles = new ArrayList<String>();
		}
		
		return roles;
		
	}



}