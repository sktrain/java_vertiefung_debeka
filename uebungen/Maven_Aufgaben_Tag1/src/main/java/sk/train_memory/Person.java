package sk.train_memory;

import java.time.LocalDate;

public class Person {
	
	private final LocalDate birthDate;

    public Person(LocalDate birthDate) {
    	// Defensive copy ist bei LocalDate (immutable) nicht nötig
        // this.birthDate = LocalDate.from(birthDate);
    	this.birthDate = birthDate;
    }

    // Other fields, methods omitted

    public boolean isBabyBoomer() {
        LocalDate boomStart = LocalDate.of(1946,1, 1);
        LocalDate boomEnd = LocalDate.of(1965,1, 1);
        return birthDate.compareTo(boomStart) >= 0 &&
               birthDate.compareTo(boomEnd)   <  0;
    }
}
