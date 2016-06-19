package list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 6/6/16.
 *
 * find the intersection and union of two sorted list, and the result list must be sorted as well the final result must
 * not have duplicate
 *
 * example: a: 1->2->5->7 b: 3->4->5->6
 *
 * intersection should be 5 union should be 1->2->3->4->5->6->7
 */
public class IntersectionAndUnion {

    public static List<Integer> union(List<Integer> a, List<Integer> b) {
        List<Integer> res = new LinkedList<>();
        Iterator<Integer> iteratorA = a.iterator();
        Iterator<Integer> iteratorB = b.iterator();
        Integer aNum = loadNext(iteratorA);
        Integer bNum = loadNext(iteratorB);
        while (aNum != null || bNum != null) {
            if (aNum != null && bNum != null) {
                if (aNum < bNum) {
                    res.add(aNum);
                    aNum = loadNextDiffNum(aNum, iteratorA);
                } else if (aNum > bNum) {
                    res.add(bNum);
                    bNum = loadNextDiffNum(bNum, iteratorB);
                } else {
                    res.add(bNum);
                    aNum = loadNextDiffNum(aNum, iteratorA);
                    bNum = loadNextDiffNum(bNum, iteratorB);
                }
            } else if (aNum != null) {
                res.add(aNum);
                aNum = loadNextDiffNum(aNum, iteratorA);
            } else {
                res.add(bNum);
                bNum = loadNextDiffNum(bNum, iteratorB);
            }
        }
        return res;
    }

    private static Integer loadNext(Iterator<Integer> iterator) {
        return iterator.hasNext() ? iterator.next() : null;
    }

    private static Integer loadNextDiffNum(Integer current, Iterator<Integer> iterator) {
        Integer next = current;
        while (iterator.hasNext() && current.equals(next)) {
            next = iterator.next();
        }
        return iterator.hasNext() ? next : null;
    }

    public static List<Integer> intersect(List<Integer> a, List<Integer> b) {
        List<Integer> res = new LinkedList<>();
        Iterator<Integer> iteratorA = a.iterator();
        Iterator<Integer> iteratorB = b.iterator();
        Integer aNum = loadNext(iteratorA);
        Integer bNum = loadNext(iteratorB);

        while (aNum != null && bNum != null) {
            if (aNum == bNum) {
                res.add(aNum);
                aNum = loadNextDiffNum(aNum, iteratorA);
                bNum = loadNextDiffNum(bNum, iteratorB);
            } else if (aNum < bNum) {
                aNum = loadNextDiffNum(aNum, iteratorA);
            } else { // aNum > bNum
                bNum = loadNextDiffNum(bNum, iteratorB);
            }
        }

        return res;


    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 5, 6, 6, 7);
        List<Integer> b = Arrays.asList(3, 4, 5, 6, 6, 6);

        System.out.println(union(a, b));
        System.out.println(intersect(a, b));


    }
}
