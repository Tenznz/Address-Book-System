package com.bridgelabz.address_book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	String firstName, lastName, address, city, state, zip, phoneNumber, email;
	static List<Contact> contactList;

	public AddressBook() {
		contactList = new ArrayList<>();
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		AddressBook.contactList = contactList;
	}

	public List<Contact> addContact() {
		Scanner sc = new Scanner(System.in);
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
		return contactList;
	}

	public void display() {
		contactList.forEach(System.out::println);
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
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getFirstName().contains(firstName)) {
				return contactList.get(i);
			}
		}
		return null;
	}

	public void viewByCityOrStateName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter State or city Name");
		String searchText = sc.next();
		Long count = contactList.stream()
				.filter(el -> (el.getCity().equals(searchText) || el.getState().equals(searchText)))
				.peek(System.out::println).count();
		System.out.println("Total count in this city or state " + count);
		contactList.stream().filter(el -> (el.getCity().equals(searchText) || el.getState().equals(searchText)))
				.forEach(p -> System.out.println("First Name :" + p.getFirstName() + "\tLast Name:" + p.getLastName()));
	}

	public void updateContact(int i) {
		Scanner sc = new Scanner(System.in);
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

	public void sortByPersonName() {
		List<Contact> sortedContact = contactList.stream().sorted(new compareToFirstName())
				.collect(Collectors.toList());
		sortedContact.forEach(System.out::println);
	}

	public void sortedContactByCity() {
		contactList.stream().sorted(new compareCity()).forEach(System.out::println);
	}

	public void sortedContactByState() {
		contactList.stream().sorted(new compareState()).forEach(System.out::println);
	}

	public void sortedContactByZip() {
		contactList.stream().sorted(new compareZip()).forEach(System.out::println);
	}
}

class compareToFirstName implements Comparator<Contact> {
	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getFirstName().compareTo(c2.getFirstName());
	}
}

class compareCity implements Comparator<Contact> {
	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getCity().compareTo(c2.getCity());
	}
}

class compareState implements Comparator<Contact> {
	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getState().compareTo(c2.getState());
	}
}

class compareZip implements Comparator<Contact> {
	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getZip().compareTo(c2.getZip());
	}
}
