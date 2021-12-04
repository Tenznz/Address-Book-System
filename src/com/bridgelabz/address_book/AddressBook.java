package com.bridgelabz.address_book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zip;
	String phoneNumber;
	String email;
	static List<Contact> contactList;

	public AddressBook() {
		contactList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "AddressBook [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}

	public static List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		AddressBook.contactList = contactList;
	}

	Scanner sc = new Scanner(System.in);

	public void addContact() {

		Contact person = new Contact();
		System.out.println("Enter your First Name");
		firstName = sc.next();
		if (checkDuplicate(firstName) == false) {
			person.setFirstName(firstName);
			System.out.println("Enter your Last Name");
			lastName = sc.next();
			person.setLastName(lastName);
			System.out.println("Enter your Address");
			address = sc.next();
			person.setAddress(address);
			System.out.println("Enter your City");
			city = sc.next();
			person.setCity(city);
			System.out.println("Enter your State");
			state = sc.next();
			person.setState(state);
			System.out.println("Enter your ZipCode");
			zip = sc.next();
			person.setZip(zip);
			System.out.println("Enter your Phone Number");
			phoneNumber = sc.next();
			person.setPhoneNumber(phoneNumber);
			System.out.println("Enter your E-mail");
			email = sc.next();
			person.setEmail(email);
			contactList.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
		} else {
			System.out.println("Duplicate value cant be add");
		}

	}

	Contact contact = new Contact();

	public void display() {

		int i = 1;
		for (Contact s : contact.getStore()) {
			System.out.println(
					"Contact." + i + " [ FirstName=" + s.getFirstName() + ", FastName=" + s.getLastName() + ", Address="
							+ s.getAddress() + ", city=" + s.getCity() + ", state=" + s.getState() + ", zip-code="
							+ s.getZip() + ", Phone Number=" + s.getPhoneNumber() + ", email=" + s.getEmail() + "]");
			i++;
		}
	}

	public int getIndex(String firstName) {
		int index = -1;
		for (int i = 0; i < contactList.size(); i++) {
			if (firstName.equals(contactList.get(i).getFirstName())) {
				return i;
			}
		}
		return index;
	}

	public boolean checkDuplicate(String firstName) {

		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getFirstName().contains(firstName)) {
				return true;
			}
		}
		return false;
	}

	public Contact getContactDetails(String firstName) {
		for (int i = 0; i < contact.getStore().size(); i++) {
			if (contact.getStore().get(i).getFirstName().contains(firstName)) {
				return contact.getStore().get(i);
			}
		}
		return null;
	}

	private int count = 0;

	public Map<String, String> searchByCityName() {
		System.out.println("Enter City Name or State Name");
		String searchText = sc.next();

		Map<String, String> a = new HashMap<>();
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getCity().contains(searchText)) {
				count++;
				a.put(contactList.get(i).getFirstName(), contactList.get(i).getCity());
			} else if (contactList.get(i).getState().contains(searchText)) {
				count++;
				a.put(contactList.get(i).getFirstName(), contactList.get(i).getState());
			}
		}
		if (count == 0) {
			System.out.println("city or state not found in Address Book");
		}
		return a;
	}

	public int getCount() {
		return count;
	}

	public void updateContact(int i) {

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
		zip = sc.next();
		System.out.println("Enter your Phone Number");
		phoneNumber = sc.next();
		System.out.println("Enter your E-mail");
		email = sc.next();
		contactList.set(i, new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
	}

	public void removeContact(int index) {
		contactList.remove(index);
	}

}