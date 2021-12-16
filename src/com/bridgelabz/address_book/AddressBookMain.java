package com.bridgelabz.address_book;

import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.address_book_io_file.AddressBookFileOperation;
import com.bridgelabz.address_book_map.MultipleAddressBook;

public class AddressBookMain {

	MultipleAddressBook books = new MultipleAddressBook();

	public void addNewAddressBook() throws IOException {
		System.out.println("Add new AddressBook \n(Yes/No)");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		while (str.equals("yes")) {
			books.newAddressBook();
			System.out.println("Add new AddressBook \n(Yes/No)");
			str = sc.next();
		}

	}

	public static void main(String[] args) throws IOException {
		AddressBook ad=new AddressBook();
		Scanner sc = new Scanner(System.in);
		AddressBookFileOperation fileIO = new AddressBookFileOperation();
		AddressBookMain ab = new AddressBookMain();
		int input = 0;
		do {
			System.out.println("1.Add AddressBook\n2.Display\n3.Exit");
			input = sc.nextInt();
			switch (input) {
			case 1:
				ab.addNewAddressBook();
				break;
			case 2:
				System.out.println("Enter Book name");
				String bookName = sc.next();
				fileIO.readAddressBookData(bookName);
			case 3:
				System.exit(0);
			}
		} while (input > 0 || input < 4);	
	}
}