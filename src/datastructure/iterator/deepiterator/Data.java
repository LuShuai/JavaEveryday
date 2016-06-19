package datastructure.iterator.deepiterator;

import java.util.Collection;
import java.util.Set;

/**
 * Created by shuailu on 6/5/16.
 */
public class Data<T> {
    T val;
    Set<Data<T>> set;

    public Data(Set<Data<T>> set) {
        this.val = null;
        this.set = set;
    }

    public Data(T val) {
        this.val = val;
        this.set = null;
    }

    // Does this Data hold a collection?
    public boolean isCollection() {
        return set != null;
    }
    // Returns the collection contained by
    // this Data, or null if it is a single element
    public Collection<Data<T>> getCollection() {
        return set;
    }
    // Returns the single element contained
    //by this Data, or null if it is  collection
    public T getElement() {
        return val;
    }
}
