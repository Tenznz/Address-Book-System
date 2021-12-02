package com.bridgelabz.address_book;

import java.util.Scanner;
import com.bridgelabz.address_book_map.MultipleAddressBook;

public class AddressBookMain {

	public static void main(String[] args) {
		MultipleAddressBook books = new MultipleAddressBook();
		System.out.println("Add new AddressBook \n(Yes/No)");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		while (str.equals("yes")) {
			books.newAddressBook();
			System.out.println("Add new AddressBook \n(Yes/No)");
			str = sc.next();
		}
		books.displayBook();
	}
}
