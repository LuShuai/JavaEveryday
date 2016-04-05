package math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 2/4/16.
 */

//https://leetcode.com/problems/factor-combinations/

public class FactorCombination {

    public static List<List<Integer>> getFactors(int n) {
        return getFactors(2, n);
    }

    private static List<List<Integer>> getFactors(int start, int n) {
        System.out.println("Calculating: start = " + start + ", n = " + n);
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if (n < 4) {
            return res;
        }

        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && i <= n / i) {
                List<Integer> base = new LinkedList<Integer>();
                base.add(i);
                base.add(n / i);
                res.add(base);
                List<List<Integer>> subRes = getFactors(i, n / i);
                for (List<Integer> factors : subRes) {
                    factors.add(0, i);
                    res.add(factors);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> res = getFactors(16);
        for (List<Integer> sub : res) {
            System.out.println(Arrays.toString(sub.toArray()));
        }
    }


}
