import org.example.DigitalLibrary;
import org.example.DigitalLibraryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DigitalLibraryTest {

	List<String> books;
	DigitalLibrary digitalLibrary;

	@Before
	public void setsUp() {
		books = new ArrayList<>();
		digitalLibrary = new DigitalLibraryImpl();
		digitalLibrary.addBook("   1   ");
		digitalLibrary.addBook("book1   ");
		digitalLibrary.addBook("  boo  k1  ");
		digitalLibrary.addBook("book1");
		digitalLibrary.addBook("book2");
		digitalLibrary.addBook("book3");
		digitalLibrary.addBook("     ");
		digitalLibrary.addBook("");
	}

	@Test
	public void testAddBook() {
		// Act
		int booksSize = digitalLibrary.getBookCount();

		// Assert
		assertEquals(6,booksSize);
	}

	@Test
	public void searchBooks_Test(){
        // Act
        List<String> allBooks = digitalLibrary.searchBooks("book2");

        // Assert
        assertEquals("book2",allBooks.getFirst());
	}

	@Test
	public void getAllBooks_Test(){
		// Act
		List<String> allBooks = digitalLibrary.getAllBooks();

		// Assert
		assertEquals(6,allBooks.size());
	}

	@Test
	public void isBookAvailable_Test(){
		// Act
        boolean isAvailable = digitalLibrary.isBookAvailable("book1");

        // Assert
		assertTrue(isAvailable);
	}

	@Test
	public void updateBookTitle_Test(){
		// Act
        boolean isUpdated = digitalLibrary.updateBookTitle("book1", "newBook1");

        // Assert
        assertTrue(isUpdated);
	}

	@Test
	public void removeBook_Test(){
		// Act
        boolean isRemoved = digitalLibrary.removeBook("book1");

        // Assert
        assertTrue(isRemoved);
	}

	@Test
	public void bookFreaquency_Test(){
		// Act
        int bookFrequency = digitalLibrary.bookFrequency();

        // Assert
        assertEquals(3,bookFrequency);
	}
}
