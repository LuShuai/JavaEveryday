package math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shuailu on 2/16/16.
 */
public class UneatenLeaves {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};

        System.out.println(getCount(arr, 100));
    }

    public static int getCount(int[] arr, int num) {

        int count = 0;
        int sign = -1;
        for (int i = 0; i < arr.length; i++) {
            sign *= -1;
            count += getInclExcl(arr, num, i + 1, sign);
        }
        return count;

    }

    private static int getInclExcl(int[] arr, int num, int subsetSize, int sign) {
        System.out.println("num = " + num);
        System.out.println("subsetSize = " + subsetSize);
        System.out.println("sign = " + sign);
        System.out.println("------------------------------------------------");

        List<Set<Integer>> list = getAllSubset(arr, subsetSize);
        int count = 0;

        for (Set<Integer> set : list) {
            int lcm = getLCMFromSet(set);
            count += num / lcm;
        }
        return count * sign;
    }

    private static List<Set<Integer>> getAllSubset(int[] arr, int subsetSize) {
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        getAllSubsetRec(arr, 0, list, set, subsetSize);
        return list;
    }

    private static void getAllSubsetRec(int[] arr, int i, List<Set<Integer>> list,
                                        Set<Integer> set, int setSize) {
        if (set.size() == setSize) {
            list.add(new HashSet<Integer>(set));
            return;
        }
        if (i == arr.length) {
            return;
        }
        set.add(arr[i]);
        getAllSubsetRec(arr, i + 1, list, set, setSize);
        set.remove(arr[i]);
        getAllSubsetRec(arr, i + 1, list, set, setSize);
    }

    private static int getLCMFromSet(Set<Integer> set) {

        return getLCMFromArray(set.toArray(new Integer[0]));
    }

    private static int getLCMOfTwoNum(int a, int b) {

        return a * (b / getGCD(a, b));
    }

    private static int getLCMFromArray(Integer[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = getLCMOfTwoNum(result, input[i]);
        }
        return result;
    }

    public static int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}
