package sk.train_inheritance;

import java.util.*;

public class InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

   //todo: ...
    
    public int getAddCount() {
        return addCount;
    }

    // kleiner Test
    public static void main(String[] args) {
        InstrumentedHashSet<String> s =
            new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));    
        System.out.println(s.getAddCount());
    }
}
