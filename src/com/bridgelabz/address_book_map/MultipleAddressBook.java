package com.bridgelabz.address_book_map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.bridgelabz.address_book.AddressBook;

public class MultipleAddressBook {
	Map<String, List> book = new HashMap();
	Scanner sc = new Scanner(System.in);
	String bookName;

	public void newAddressBook() {
		System.out.println("Enter Book name");
		bookName = sc.next();
		if (book.containsKey(bookName)) {
			System.out.println("Address book name exists");
		} else {
			addAddressBook();
			book.put(bookName, AddressBook.getContactList());
		}
	}

//	public boolean searchName(String name) {
//		return book.containsValue(name);
//	}

	public void addAddressBook() {

		AddressBook addressBook = new AddressBook();
		int act;
		System.out.println("Welcome to Address Book");
		do {
			System.out.println("Enter\n1.Add\n2.Update\n3.Delete\n4.Print\n5.Exit");
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
				System.out.println("exit " + bookName);
				act = 0;
			}
		} while (act > 0 || act > 5);

	}

	public void displayBook() {
		System.out.println("AddressBooks");
		for (Entry<String, List> entry : book.entrySet()) {
			System.out.println("Address Book name is " + entry.getKey() + "\nvalue :-\n" + entry.getValue().toString());
		}
	}

}
