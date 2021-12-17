package com.bridgelabz.address_book_io_file;

import java.io.IOException;
import java.util.List;
import com.bridgelabz.address_book.Contact;

public interface ReadWrite {
	void read(String BookName) throws IOException;

	void write(List<Contact> contactList) throws IOException;
}
