package com.bridgelabz.address_book_map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.bridgelabz.address_book.AddressBook;
import com.bridgelabz.address_book.Contact;

public class MultipleAddressBook {
	Map<String, List<Contact>> book = new HashMap<>();
	AddressBook addressBook = new AddressBook();
	Contact contact = new Contact();
	Scanner sc = new Scanner(System.in);
	String bookName;

	public void newAddressBook() {
		System.out.println("Enter Book name");
		bookName = sc.next();
		if (book.containsKey(bookName)) {
			System.out.println("Address book name exists");
		} else {
			addAddressBook();
			book.put(bookName, contact.getStore());
		}
	}
//	public void addNewAddressBook() {
//		System.out.println("Enter Name of new Address Book: ");
//		Scanner sc = new Scanner(System.in);
//		String bookName = sc.next();
//		if (book.containsKey(bookName)) {
//			System.out.println("Address book with this name exists, Enter new name.");
//			addNewAddressBook();
//		} else {
//			AddressBook addressBook = new AddressBook();
//			book.put(bookName, addressBook);
//			System.out.println("press 1 if you want to add another book or press any key to exit.");
//			int newBook = sc.nextInt();
//			if (newBook == 1) {
//				addAddressBook();
//			}
//		}
//	}

	public void searchByName(String name) {

		for (String entry : book.keySet()) {
			Contact contact = addressBook.getContactDetails(name);
			if (contact == null) {
				System.out.println("contact not found");
			} else {
				System.out.println(contact);
			}
			return;
		}
		System.out.println("Not Found");
	}

	public void addAddressBook() {
		int act;

		System.out.println("Welcome to Address Book");
		do {
			System.out.println("Enter\n1.Add\n2.Update\n3.Delete\n4.Print\n5.Search by City or State\n6.Exit");
			act = sc.nextInt();
			int index = -1;
			String fName;
			switch (act) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				System.out.println("Enter your First name to update");
				fName = sc.next();
				index = addressBook.getIndex(fName);
				if (index < 0) {
					break;
				}
				addressBook.updateContact(index);
				break;
			case 3:
				System.out.println("Enter your First name to delete");
				fName = sc.next();
				index = addressBook.getIndex(fName);
				addressBook.removeContact(index);
				break;

			case 4:
				addressBook.display();
				break;
			case 5:
				Map<String, String> map = new HashMap<>();
				map = addressBook.searchByCityName();
				for (Map.Entry<String, String> entry : map.entrySet()) {
					System.out.println(entry.getKey() + "-" + entry.getValue());
				}
				break;
			case 6:
				System.out.println("exit " + bookName);
				act = 0;
			}

		} while (act > 0 || act > 5);
		contact.setStore(AddressBook.getContactList());
		new AddressBook();
		System.out.println(contact.getStore());

	}

	public void displayBook() {
		System.out.println("Total AddressBooks");
		int i = 1;
		for (Entry<String, List<Contact>> entry : book.entrySet()) {
			System.out.println((i++) + "." + entry.getKey());
		}
	}

}
