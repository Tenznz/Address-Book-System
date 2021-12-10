package com.bridgelabz.address_book_map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bridgelabz.address_book.AddressBook;
import com.bridgelabz.address_book.Contact;

public class MultipleAddressBook {
	Map<String, List> book = new HashMap<>();
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
			new AddressBook();
			addAddressBook();
			book.put(bookName, addressBook.getContactList());
		}
	}

//	public void searchByCityName() {
//		System.out.println("Enter City Name");
//		AddressBook ad = new AddressBook();
//		String searchText = sc.next();
//		book.entrySet().stream().filter(el -> ad.getContactList().toArray().equals(searchText))
//				.forEach(System.out::println);
//
//	}

	public void addAddressBook() {
		int act;

		System.out.println("Welcome to Address Book");
		do {
			System.out.println("Enter\n1.Add\n2.Update\n3.Delete\n4.Print\n5.Search by city\n6.Exit");
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
				addressBook.viewByCityOrStateName();
				break;
			case 6:
				System.out.println("exit " + bookName);
				act = 0;
			}

		} while (act > 0 || act > 5);

	}

	public void displayBook() {
		System.out.println("Total AddressBooks");
		book.entrySet().stream().forEach(System.out::println);
	}

}
