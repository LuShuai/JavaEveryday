package datastructure.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 6/13/16.
 */
public class TwoDListIterator implements Iterator<Integer> {

    Iterator<List<Integer>> listIterator;
    Iterator<Integer> intIterator;

    public TwoDListIterator(List<List<Integer>> vec2d) {
        if (vec2d == null) {
            return;
        }
        listIterator = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return intIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (intIterator != null && intIterator.hasNext()) {
            return true;
        }
        List<Integer> nextList = null;
        while (listIterator.hasNext() && (nextList == null || nextList.isEmpty())) {
            nextList = listIterator.next();
        }
        if (nextList == null) {
            return false;
        }
        intIterator = nextList.iterator();
        return intIterator.hasNext();
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3);
        List<Integer> list3 = Arrays.asList(4, 5, 6);
        List<List<Integer>> listOfList = new LinkedList<>();
        listOfList.add(list1);
        listOfList.add(list2);
        listOfList.add(new LinkedList<Integer>());
        listOfList.add(list3);
        TwoDListIterator iterator = new TwoDListIterator(listOfList);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
