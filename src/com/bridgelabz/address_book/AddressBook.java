package com.bridgelabz.address_book;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contact contact = new Contact();
		System.out.println("How many Contact you want to add?");
		int totalNumber = sc.nextInt();

		int i = 1;
		while (i <= totalNumber) {
			System.out.println(i + "Address :");
			contact.addContact();
//			contact.display();
			i++;
		}
		i = 1;
		for (Contact s : contact.contactList) {

			System.out.println("Contact.1 [ firstName=" + contact.getFirstName() + ", lastName=" + contact.getLastName()
					+ ", address=" + contact.getAddress() + ", city=" + contact.getCity() + ", state="
					+ contact.getState() + ", zip=" + contact.getZip() + ", phoneNumber=" + contact.getPhoneNumber()
					+ ", email=" + contact.getEmail() + "]");
			i++;
		}
		sc.close();
	}
}
