/* leider nicht korrekt */

package sk.train_inheritance;

import java.util.*;

public class InstrumentedHashSetNotCorrect<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSetNotCorrect() {
    }

    public InstrumentedHashSetNotCorrect(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSetNotCorrect<String> s =
            new InstrumentedHashSetNotCorrect<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));    
        System.out.println(s.getAddCount());
    }
}
