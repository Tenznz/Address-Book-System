package com.bridgelabz.address_book_map;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bridgelabz.address_book.AddressBook;
import com.bridgelabz.address_book.Contact;
import com.bridgelabz.address_book_io_file.AddressBookFileOperation;

public class MultipleAddressBook {

	public Map<String, List> book = new HashMap<>();

	AddressBook addressBook = new AddressBook();
	Contact contact = new Contact();
	Scanner sc = new Scanner(System.in);
	String bookName;

	public void newAddressBook() throws IOException {
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

	public void addAddressBook() throws IOException {
		int act;

		System.out.println("Welcome to Address Book");
		do {
			System.out.println(
					"Enter\n1.Add\n2.Update\n3.Delete\n4.Print\n5.Search by city\n6.sort by person name\n7.Exit");
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
				AddressBookFileOperation fileIO = new AddressBookFileOperation();
				fileIO.writeAddressBookData(addressBook);
				break;
			case 5:
				addressBook.viewByCityOrStateName();
				break;
			case 6:
				System.out.println("Sort by \n1.Name\n2.ZipCode\n3.City\n4.State");
				int input = sc.nextInt();
				if (input == 1)
					addressBook.sortByPersonName();
				else if (input == 2) {
					addressBook.sortedContactByZip();
				} else if (input == 3) {
					addressBook.sortedContactByCity();
				} else if (input == 4) {
					addressBook.sortedContactByState();
				}
				break;
			case 7:
				System.out.println("exit " + bookName);
				act = 0;

			}

		} while (act > 0 || act > 8);

	}

	public void displayBook() throws IOException {
		System.out.println("Total AddressBooks");

		book.entrySet().stream().forEach(System.out::println);
	}

}
