package dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 4/18/16.
 *
 * Cut the number (presented as string) such that the parts add up to target for example:
 *
 * String: 1234, target: 46 output should be {1} because cut after index 1, string will be 12,34 which add up to 46.
 */


public class CutNumberToTarget {

    public static List<Integer> cuts(String num, int target) {
        List<Integer> res = new LinkedList<Integer>();
        cuts(num, target, 0, res);
        return res;
    }

    public static boolean cuts(String num, int target, int start, List<Integer> currentPath) {
        String subString = num.substring(start, num.length());
        int val = Integer.parseInt(subString);
        if (num.length() < 1) {
            return false;
        }
        if (val == target) {
            return true;
        }
        //cut
        for (int n = start; n < num.length() - 1; n++) {
            int newTarget = target - Integer.parseInt(num.substring(start, n + 1));
            if (newTarget > 0) {
                if (cuts(num, newTarget, n + 1, currentPath)) {
                    currentPath.add(n);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(cuts("1234", 46));  //[1]
        System.out.println(cuts("123", 6));  //[1, 0]
        System.out.println(cuts("1235", 29));  //[2, 0]
    }
}
