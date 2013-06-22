

package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.math.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



@Entity
public class Student extends Model {


	
    public String firstName;
    
    public String lastName;
   
    public String dateOfBirth; 
	
    public String street;
	
    public int postalCode;
    
    public String email;
    
    public String levelOfStudy;
    
    public String university;
    
    public int phoneNumber;
    
    public String image;
   
    public String pwHash;

	public String confirmationCode;

	public String recoverPasswordCode;

	private ArrayList<String> roles;
    
	
	public Student(String firstName, String lastName, String university, String email,String dateOfBirth, String street, int postalCode, int phoneNumber, String passwordHash, String confirmationCode) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.university = university;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.street = street;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
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

