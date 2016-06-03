package someTest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by shuailu on 5/31/16.
 */
public class XSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n = 0; n < nums.length; n++) {
            map.put(target - nums[n], n);
        }

        for (int n = 0; n < nums.length; n++) {
            Integer index = map.get(nums[n]);
            if (index != null && index != n) {
                if (index > n) {
                    res[0] = n;
                    res[1] = index;
                } else {
                    res[0] = index;
                    res[1] = n;
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
    }

}
