package com.bridgelabz.address_book_io_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.bridgelabz.address_book.AddressBook;
import com.bridgelabz.address_book_map.MultipleAddressBook;

public class AddressBookFileOperation {
	public static final String loc = "D:\\project\\Learning_Path\\RFP\\Address-Book-System\\src\\AddressBook";

	public void readAddressBookData() throws FileNotFoundException {

		File file = new File(loc);
		Scanner sf = new Scanner(file);

		String data = null;
		while (sf.hasNextLine())
			data = sf.nextLine();
		System.out.println("AddressBook:-\n" + data);
	}

	public void writeAddressBookData(AddressBook ad) throws IOException {
		MultipleAddressBook ma = new MultipleAddressBook();
		FileWriter output = new FileWriter(loc);
//		 Writes string to the file
//		String data = ma.book.entrySet().toArray().toString();
//		for (Entry<String, List> a : ma.book.entrySet()) {
//			data = data + (String) a.getKey();
//		}
//		System.out.print(data);
		
		output.write(ad.getContactList().toString());
		System.out.println("Data file.");

		// Closes the writer
		output.close();
	}
}
