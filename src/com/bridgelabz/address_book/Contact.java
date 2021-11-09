package com.bridgelabz.address_book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {

	Scanner sc = new Scanner(System.in);

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String email;
	List<Contact> contactList = new ArrayList<Contact>();

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	public Contact() {
	}

	Contact(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	void addContact() {

		System.out.println("Enter your First Name");
		firstName = sc.next();
		System.out.println("Enter your Last Name");
		lastName = sc.next();
		System.out.println("Enter your Address");
		address = sc.next();
		System.out.println("Enter your City");
		city = sc.next();
		System.out.println("Enter your State");
		state = sc.next();
		System.out.println("Enter your ZipCode");
		zip = sc.nextInt();
		System.out.println("Enter your Phone Number");
		phoneNumber = sc.nextLong();
		System.out.println("Enter your E-mail");
		email = sc.next();
		contactList.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));

	}

//	void display() {
//		for (Contact s : contactList) {
//			System.out.println("Contact.1 [ FirstName=" + firstName + ", FastName=" + lastName + ", Address=" + address
//					+ ", city=" + city + ", state=" + state + ", zip-code=" + zip + ", Phone Number=" + phoneNumber
//					+ ", email=" + email + "]");
//		}
//	}
//	void display() {
//		for (Contact s : contactList) {
//			System.out.println("Contact.1 [ firstName=" + getFirstName() + ", lastName=" + getLastName() + ", address="
//					+ getAddress() + ", city=" + getCity() + ", state=" + getState() + ", zip=" + getZip()
//					+ ", phoneNumber=" + getPhoneNumber() + ", email=" + getEmail() + "]");
//		}
//	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

}
