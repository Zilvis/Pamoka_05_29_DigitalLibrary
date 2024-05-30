package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DigitalLibraryImpl implements DigitalLibrary{
	private List<String> books;
	private Map<String, Integer> bookFrequency;


	public DigitalLibraryImpl() {
		this.books = new ArrayList<>();
		this.bookFrequency = new HashMap<>();
	}

	public int bookFrequency (){
		for (String book : books){
			if (bookFrequency.containsKey(book.trim())) {
                bookFrequency.put(book, bookFrequency.get(book) + 1);
            } else {
                bookFrequency.put(book, 1);
            }
		}
		return bookFrequency.size();
	}

	public void addBook(String book) {
		if (book != null && !book.trim().isEmpty()) {
			books.add(book);
		}
	}

	public List<String> getAllBooks() {
		return books;
	}

	public List<String> searchBooks(String query) {
		return books.stream()
				.filter(book -> book.toLowerCase().contains(query.toLowerCase()))
				.collect(Collectors.toList());
	}


	public int getBookCount() {
		return books.size();
	}


	public boolean isBookAvailable(String title) {
		return books.contains(title);
	}

	public boolean updateBookTitle(String oldTitle, String newTitle) {
		int index = books.indexOf(oldTitle);
		if (index != -1 && newTitle != null && !newTitle.trim().isEmpty()) {
			books.set(index, newTitle);
			return true;
		}
		return false;
	}

	public boolean removeBook(String title) {
		return books.remove(title);
	}


}
