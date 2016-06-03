package arrays;

/**
 * Created by shuailu on 5/29/16.
 */
public class MaxSubArrayProduct {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int max, min, res;
        res = max = min = nums[0];

        for (int n = 1; n < nums.length; n++) {
            int num = nums[n];
            if (num > 0) {
                max = Math.max(num, num * max);
                min = Math.min(num, num * min);
            } else {
                max = Math.max(num, num * min);
                min = Math.min(num, num * max);
            }
            res = Math.max(res, max);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4, -3, -2}));
    }
}
