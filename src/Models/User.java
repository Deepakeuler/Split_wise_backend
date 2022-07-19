package Models;

import java.util.HashMap;

public class User {

	private String user_id;

	private String name;

	private String contact;

	private char gender;

	private String email;

	 HashMap<User, Integer> owes;

	User(String user_id, String name, String number, char gender) {
		this.user_id = user_id;
		this.name = name;
		this.contact = number;
		this.gender = gender;
		this.owes = new HashMap<>();
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HashMap<User, Integer> getOwes() {
		return owes;
	}



}
