//static initializer vermeidet unnötige Objekt-Kopien

package sk.train_memory;

import java.util.*;

public class Person_old {
    private final Date birthDate;

    public Person_old(Date birthDate) {
        // Defensive copy
        this.birthDate = new Date(birthDate.getTime());
    }

    // Other fields, methods

    /**
     * The starting and ending dates of the baby boom.
     */
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal =
            Calendar.getInstance();
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
//        System.err.println(BOOM_START.getTime());
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
               birthDate.compareTo(BOOM_END)   <  0;
    }
}
