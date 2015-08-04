package someTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by shuailu on 8/3/15.
 */
public class TwoDListIterator implements Iterator<Integer>{

    ArrayList<ArrayList<Integer>> map;

    public TwoDListIterator(ArrayList<ArrayList<Integer>> map) {
        this.map = map;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
