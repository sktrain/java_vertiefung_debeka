package observerObservable.bookserv;

import java.util.Random;

@ISBN
public class IsbnGenerator implements NumberGenerator {
	public String generateNumber() {
			return "13-84356-" + Math.abs(new Random().nextInt());
}
}
