package math;

/**
 * Created by shuailu on 3/21/16.
 */
public class PatchingArray {

    public static int minPatches(int[] nums, int n) {
        int cnt = 0, i = 0;
        for (long knownSum = 1; knownSum <= n; ) {
            if (i < nums.length && knownSum >= nums[i]) {
                knownSum += nums[i];
                i++;
            } else {
                knownSum <<= 1;
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[] a = {5};
        System.out.println(minPatches(a, 10));
    }
}
