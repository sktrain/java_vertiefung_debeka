package observerObservable.bookserv;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

public class BookService {
	
	@Inject
	@ISBN
	private NumberGenerator numberGenerator;
	
	//Event für Benachrichtigung der Observer
	@Inject
	private Event<Book> bookAddedEvent;
	

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		
		// Event senden an CDI-Vermittler
		bookAddedEvent.fire(book);
		
		return book;
	}
}
