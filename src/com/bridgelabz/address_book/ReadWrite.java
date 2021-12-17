package com.bridgelabz.address_book;

import java.io.IOException;
import java.util.List;

public interface ReadWrite {
	void read(String BookName) throws IOException;

	void write(List<Contact> contactList) throws IOException;
}
