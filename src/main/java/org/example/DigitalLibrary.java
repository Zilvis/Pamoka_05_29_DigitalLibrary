package org.example;

import java.util.List;
import java.util.Map;

public interface DigitalLibrary {
	void addBook(String book);
	List<String> getAllBooks();
	List<String> searchBooks(String query);
	int getBookCount();
	boolean isBookAvailable(String title);
	boolean updateBookTitle(String oldTitle, String newTitle);
	boolean removeBook(String title);
	int bookFrequency ();
}
