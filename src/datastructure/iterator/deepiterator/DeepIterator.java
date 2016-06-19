package datastructure.iterator.deepiterator;

import java.util.Iterator;

/**
 * Created by shuailu on 6/5/16.
 */
public class DeepIterator<T> implements Iterator<Data<T>> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Data<T> next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

}
