package com.bridgelabz.address_book;

import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.address_book_io_file.AddressBookFileOperation;
import com.bridgelabz.address_book_map.MultipleAddressBook;

public class AddressBookMain {

	MultipleAddressBook books = new MultipleAddressBook();

	@SuppressWarnings("resource")
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
		Scanner sc = new Scanner(System.in);
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
				System.out.println("Enter \n1file read\n2csv file read");
				int option = sc.nextInt();
				System.out.println("Enter Book name");
				String bookName = sc.next();
				if (option == 1) {
					AddressBookFileOperation fileIO = new AddressBookFileOperation();
					fileIO.read(bookName);
				} else if (option == 2) {
					FileCSV fileIO = new FileCSV();
					fileIO.read(bookName);
				}
				break;

			case 3:
				System.exit(0);
			}
		} while (input > 0 || input < 4);
	}
}