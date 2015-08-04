package datastructure;

import java.util.TreeSet;

/**
 * Created by shuailu on 6/12/15.
 */
public class TreeSetTest {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int n = 0; n < nums.length; n++) {
            //deleted the last one, maintain a window
            if (n - k - 1 >= 0) {
                set.remove(nums[n - k - 1]);
            }
            if (set.contains(nums[n])) {
                return true;
            } else {
                Integer ceil = set.ceiling(nums[n]);
                Integer floor = set.floor(nums[n]);
                Long diff1 = null;
                Long diff2 = null;
                if (ceil != null) {
                    diff1 = (long) ceil - (long) nums[n];
                }
                if (floor != null) {
                    diff2 = (long) nums[n] - (long) floor;
                }
                if ((ceil != null && (diff1 <= t))
                    || (floor != null && diff2 <= t)) {
                    return true;
                }
                set.add(nums[n]);
            }

        }
        return false;
    }

    public static void main(String[] arges) {
        int[] a = {-1, 2147483647};
        System.out.println(containsNearbyAlmostDuplicate(a, 1, 2147463847));
    }
}
