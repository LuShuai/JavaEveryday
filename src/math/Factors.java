package math;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 6/9/16.
 */
public class Factors {

    public static List<List<Integer>> getFactors(int num) {
        return getFactors(num, 2);
    }

    public static List<List<Integer>> getFactors(int num, int start) {

        List<List<Integer>> res = new LinkedList<>();
        if (num < 4) {
            return res;
        }

        for (int n = start; n <= Math.sqrt(num); n++) {
            int quotient = num / n;
            if (num % n == 0 && quotient >= n) {
                List<Integer> list = new LinkedList<>();
                list.add(n);
                list.add(quotient);
                res.add(list);
                for (List<Integer> subList : getFactors(quotient, n)) {
                    subList.add(n);
                    res.add(subList);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        for (int n = 0; n < 15; n++) {
            System.out.println("Factors for number " + n + ": " + getFactors(n));
        }
    }






}
