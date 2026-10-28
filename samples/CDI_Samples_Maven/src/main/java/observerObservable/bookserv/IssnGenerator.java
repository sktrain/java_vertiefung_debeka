package observerObservable.bookserv;

import java.util.Random;

@ISSN
public class IssnGenerator implements NumberGenerator {
	public String generateNumber() {
		return "8-" + Math.abs(new Random().nextInt());
	}
}
