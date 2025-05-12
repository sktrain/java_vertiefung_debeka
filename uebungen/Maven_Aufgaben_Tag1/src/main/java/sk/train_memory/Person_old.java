package sk.train_memory;

import java.util.*;

public class Person_old {
	
    private final Date birthDate;

    public Person_old(Date birthDate) {
    	// Defensive copy
        this.birthDate = new Date(birthDate.getTime());
    }

    // Other fields, methods omitted

    public boolean isBabyBoomer() {
        Calendar gmtCal =
            Calendar.getInstance();
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 &&
               birthDate.compareTo(boomEnd)   <  0;
    }
}
