package arrays;

/**
 * Created by shuailu on 5/19/15.
 */
public class MaxSubArrayWithOrWithoutIndex {

    //return the max value of subarray without finding its index
    public static int getMaxValue(int[] a) {
        int currentSum = 0;
        int currentMax = Integer.MIN_VALUE;

        for (int n = 0; n < a.length; n++) {
            currentSum += a[n];
            currentMax = currentMax > currentSum ? currentMax : currentSum;
            currentSum = currentSum > 0 ? currentSum : 0;
        }
        return currentMax;
    }

    /*return the indexes of start and end point of this array
    [0] is the start
    [1] is the end
    */
    public static int[] getMaxIndex(int[] a) {
        int currentStart = -1;
        int currentEnd = -1;
        int currentSum = 0;

        int maxStart = -1;
        int maxEnd = -1;
        int maxSum = Integer.MIN_VALUE;

        int[] res = new int[2];
        for (int n = 0; n < a.length; n++) {
            if (currentStart < 0) {
                currentStart = n;
                currentEnd = currentStart - 1;
            }
            ++currentEnd;
            currentSum += a[n];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = currentStart;
                maxEnd = currentEnd;
            }

            if (currentSum < 0) {
                currentStart = -1;
                currentSum = 0;
            }
        }
        res[0] = maxStart;
        res[1] = maxEnd;
        return res;
    }


    public static void main(String[] args) {
        int[] a = {-1, 3, 2, -10, 6};
        int[] b = {-1, 3, 2, -10, 4};

        System.out.println(getMaxValue(a));
        System.out.println(getMaxValue(b));

        int[] arr1 = getMaxIndex(a);        // max = 6
        int[] arr2 = getMaxIndex(b);        // max = 5
        System.out.println(arr1[0] + "\t" + arr1[1]);   // (4,4)
        System.out.println(arr2[0] + "\t" + arr2[1]);   // (1,2)
    }

}
