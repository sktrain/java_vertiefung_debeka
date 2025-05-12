package sk.train.instrumentedHashSet;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSetHasA<E>  {
    // The number of attempted element insertions
    private int addCount = 0;
    private HashSet<E> hashset;

    public InstrumentedHashSetHasA() {
    	hashset = new HashSet<E>();
    }

    public InstrumentedHashSetHasA(int initCap, float loadFactor) {
    	hashset = new HashSet<E>(initCap, loadFactor);
    }

    public boolean add(E e) {
        addCount++;
        return hashset.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return hashset.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public boolean containsAll(Collection<E> col) {
    	return hashset.containsAll(col);
    }
}

