package com.bridgelabz.address_book_io_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bridgelabz.address_book.Contact;
import com.bridgelabz.address_book_map.MultipleAddressBook;
import com.google.gson.Gson;

public class FileJSON implements ReadWrite {

	@Override
	public void read(String bookName) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(
				AddressBookFileOperation.addressBookFolder + "\\" + bookName + "\\" + bookName + ".JSON"));
		Gson gson = new Gson();
		Contact[] contacts = gson.fromJson(read, Contact[].class);
		int i = 1;
		for (Contact contact : contacts) {
			System.out.println(i + ".Contact {");
			System.out.println("\tfirstName: " + contact.getFirstName());
			System.out.println("\tlastName: " + contact.getLastName());
			System.out.println("\tAddress: " + contact.getAddress());
			System.out.println("\tCity: " + contact.getCity());
			System.out.println("\tState: " + contact.getState());
			System.out.println("\tZip: " + contact.getZip());
			System.out.println("\tPhoneNumber: " + contact.getPhoneNumber());
			System.out.println("\tEmail: " + contact.getEmail());
			System.out.println("\t}");
			System.out.println("==========================");
			i++;
		}
	}

	@Override
	public void write(List<Contact> contactList) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(contactList);
		FileWriter writer;
		try {
			writer = new FileWriter(AddressBookFileOperation.addressBookFolder + "\\" + MultipleAddressBook.bookName
					+ "\\" + MultipleAddressBook.bookName + ".JSON");
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
