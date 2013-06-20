package models.casino.jpa;

import java.util.List;

import models.Student;

import play.Logger;

import casino.Casino;
import casino.CasinoUserManager;

public class JpaUserManager implements CasinoUserManager {

	
	public boolean createNewCasinoUser(String firstName,String lastName, String levelOfStudy,String university, String email, String dateOfBirth, String street, int postalCode, int phoneNumber, String passwordHash,
			String confirmationCode) {

	Student student = getOneUserWithEmail(email);
		
		if (student != null) {
			
			return false;
		}
		
		
		
		student = new Student(firstName, lastName, levelOfStudy, university, email, dateOfBirth, street, postalCode, phoneNumber, passwordHash, confirmationCode);
		student.save();
		
		return true;

	}

	
	public boolean isUserActivated(String email) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return false;
		}

		// make sure the user confirmed the name
		if (student.confirmationCode.length() != 0) {
			return false;
		}

		return true;
	}

	
	public boolean hasRole(String email, String role) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return false;
		}

		return student.hasRole(role);

	}

	
	public void addRole(String email, String role) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return;
		}

		student.addRole(role);
		student.save();

	}

	
	public void removeRole(String email, String role) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return;
		}
		
		student.removeRole(role);
		student.save();

	}

	
	public void setRecoveryPasswordCode(String email,
			String recoveryPasswordCode) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return;
		}

		student.recoverPasswordCode = recoveryPasswordCode;
		student.save();

	}

	
	public String getCasinoUserWithConfirmationCode(String confirmationCode) {

		List<Student> student = Student.find("confirmationCode", confirmationCode)
				.fetch();

		if (student.size() == 0) {

			return null;

		} else if (student.size() > 1) {

			Logger.error("more than one User with  confirmation code "
					+ confirmationCode
					+ " (JPA found). that's an inconsistency - taking the first one...");

		}

		return student.get(0).email;

	}

	
	public void deleteConfirmationCodeOfCasioUser(String email) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return;
		}

		student.confirmationCode = "";
		student.save();

	}

	
	public String getUserPasswordHash(String email) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return null;
		}

		return student.pwHash;
	}
	
	public void setNewPasswordHashForUser(String email, String passwordHash) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return;
		}

		student.pwHash = passwordHash;

		student.save();

	}

	
	public boolean doesUserExist(String email) {

		Student student = getOneUserWithEmail(email);

		if (student == null) {
			return false;
		}

		return true;
	}

	
	public String getCasinoUserWithRecoveryPasswordCode(
			String recoverPasswordCode) {

		List<Student> student = Student
				.find("recoverPasswordCode", recoverPasswordCode).fetch();

		if (student.size() == 0) {

			return null;

		} else if (student.size() > 1) {

			Logger.error("more than one User with  recoverPasswordCode "
					+ recoverPasswordCode
					+ " (JPA found). that's an inconsistency - taking the first one...");

		}

		return student.get(0).email;
	}

	private Student getOneUserWithEmail(String email) {

		List<Student> student = Student.find("email", email).fetch();

		if (student.size() == 0) {

			return null;

		} else if (student.size() > 1) {

			Logger.error("more than one User "
					+ email
					+ " (JPA found). that's an inconsistency - taking the first one...");

		}

		return student.get(0);

	}

}
