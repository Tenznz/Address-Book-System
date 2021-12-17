package com.bridgelabz.address_book_io_file;

import com.bridgelabz.address_book.Contact;
import com.bridgelabz.address_book_map.MultipleAddressBook;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.Reader;

public class FileCSV implements ReadWrite {
	MultipleAddressBook ad = new MultipleAddressBook();
	
	@Override
	public void read(String bookName) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(AddressBookFileOperation.addressBookFolder + "\\" + bookName+"\\"+bookName+ ".csv"));) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			CsvToBean<Contact> csvToBean = new CsvToBeanBuilder(reader).withType(Contact.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			Iterator<Contact> csvUserIterator = csvToBean.iterator();
			System.out.println(bookName + ":-");
			while (csvUserIterator.hasNext()) {
				Contact csvUser = csvUserIterator.next();
				System.out.println("Name First : " + csvUser.getFirstName());
				System.out.println("Name Last: " + csvUser.getLastName());
				System.out.println("address: " + csvUser.getAddress());
				System.out.println("State: "+csvUser.getState());
				System.out.println("city : " + csvUser.getCity());
				System.out.println("zip : " + csvUser.getZip());
				System.out.println("PhoneNo : " + csvUser.getPhoneNumber());
				System.out.println("Email : " + csvUser.getEmail());
				System.out.println("==========================");
			}
		}

	}

	@Override
	public void write(List<Contact> contactList) throws IOException {
		String bookFileWrite = AddressBookFileOperation.addressBookFolder + "\\" + MultipleAddressBook.bookName+ "\\" + MultipleAddressBook.bookName + ".csv";
		Path bookFile = Paths.get(bookFileWrite);
		Files.createFile(bookFile);

		try (Writer writer = Files.newBufferedWriter(Paths.get(bookFileWrite));
				CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);) {
			String[] headerRecord = { "firstName", "lastName", "address", "city", "state", "zip", "phoneNumber",
					"email" };
			csvWriter.writeNext(headerRecord);
			contactList.stream()
					.forEach(contact -> csvWriter.writeNext(new String[] { contact.getFirstName(),
							contact.getLastName(), contact.getAddress(), contact.getCity(), contact.getState(),
							contact.getZip(), contact.getPhoneNumber(), contact.getEmail() }));

		}
	}
}
