package com.bridgelabz.address_book_io_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.address_book.Contact;
import com.bridgelabz.address_book_map.MultipleAddressBook;

public class AddressBookFileOperation implements ReadWrite {
	int counter = 1;
//	public static final String loc = "D:\\project\\Learning_Path\\RFP\\Address-Book-System\\src\\AddressBook";
	public static final String addressBookFolder = "D:\\project\\Learning_Path\\RFP\\Address-Book-System\\src";

	public void read(String name) throws FileNotFoundException {

		File file = new File(addressBookFolder + "\\" + name + "\\" + name + ".txt");
		Scanner sf = new Scanner(file);
		System.out.println(name + ":-\n");
		while (sf.hasNextLine())
			System.out.println(sf.nextLine());
		sf.close();
	}

	public void write(List<Contact> contactList) throws IOException {
		String url = addressBookFolder + "\\" + MultipleAddressBook.bookName;
		Path bookPath = Paths.get(url);
		Files.createDirectories(bookPath);
		String bookFileWrite = url + "\\" + MultipleAddressBook.bookName + ".txt";
		Path bookFile = Paths.get(bookFileWrite);
		Files.createFile(bookFile);

		FileWriter output = new FileWriter(bookFileWrite);
		StringBuffer addressBuffer = new StringBuffer();
		contactList.forEach(contact -> {
			String employeeDataString = contact.toString().concat("\n");
			addressBuffer.append(employeeDataString);
		});
		output.write(addressBuffer.toString());
		System.out.println("Data added in file.");
		output.close(); // Closes the writer
	}
}
