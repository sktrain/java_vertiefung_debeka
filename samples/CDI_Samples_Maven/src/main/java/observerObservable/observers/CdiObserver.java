package observerObservable.observers;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.event.Observes;
import observerObservable.bookserv.Book;

public class CdiObserver {
	
	List<Book> inventory = new ArrayList<>();
	
	public void addBook(@Observes Book book) {
		System.out.println("Adding book " + book.getTitle() + " to inventory");
		inventory.add(book);
		}

}
