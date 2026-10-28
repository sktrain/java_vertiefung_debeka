package observerObservable;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import observerObservable.bookserv.Book;
import observerObservable.bookserv.BookService;

public class Starter {
	public static void main(String[] args) {
		
		try(SeContainer secontainer = SeContainerInitializer.newInstance().initialize()) {
			// start the container, retrieve a bean and do work with it
			
			BookService myBean = secontainer.select(BookService.class).get();
			Book book1 = myBean.createBook("H2G2", 12.5f, "Geeky scifi Book");
			System.out.println(book1);
			
		}
			// shuts down automatically after the try with resources block.
	}		
}
