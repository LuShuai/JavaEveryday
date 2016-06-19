package datastructure.iterator.filterItertor;

import java.util.Iterator;

/**
 * Created by shuailu on 6/9/16.
 */
public class FilterIterator<T> implements Iterator<T>{

    Tester tester;
    T cachedNext;



    @Override
    public boolean hasNext() {
        return cachedNext != null;
    }

    @Override
    public T next() {
        return null;
    }
}
