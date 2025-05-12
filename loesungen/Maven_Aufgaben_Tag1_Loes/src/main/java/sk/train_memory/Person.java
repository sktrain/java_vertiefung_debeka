package sk.train_memory;

import java.time.LocalDate;

public class Person {
	
	private static final LocalDate BOOM_START = LocalDate.of(1946,1, 1);
    private static final LocalDate BOOM_END = LocalDate.of(1965,1, 1);

	
	private final LocalDate birthDate;

    public Person(LocalDate birthDate) {
    	// Defensive copy ist bei LocalDate (immutable) nicht nötig
        // this.birthDate = LocalDate.from(birthDate);
    	this.birthDate = birthDate;
    }

    // Other fields, methods omitted

    public boolean isBabyBoomer() {
       return birthDate.compareTo(BOOM_START) >= 0 &&
               birthDate.compareTo(BOOM_END)   <  0;
    }
}
