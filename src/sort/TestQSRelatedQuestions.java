package sort;

import java.util.Random;

/**
 * Created by shuailu on 8/31/15.
 */
public class TestQSRelatedQuestions {


    private static int partition(int[] num, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }

        Random random = new Random();
        int index = left + random.nextInt(right - left + 1);
        swap(num, left, index);
        int pivot = num[left];
        int low = left + 1;
        int hi = right;
        while (low < hi) {
            while (low < hi && num[low] <= pivot) {
                low++;
            }
            while (low < hi && num[hi] > pivot) {
                hi--;
            }
            if (hi > low) {
                swap(num, low, hi);
                low++;
                hi--;
            }
        }
        if (num[low] <= pivot) {
            swap(num, low, left);
            return low;
        } else {
            swap(num, left, low - 1);
            return low - 1;
        }
    }


    private static void swap(int[] num, int left, int right) {
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }

    private static void quickSort(int[] num, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(num, left, right);
        quickSort(num, left, pivot - 1);
        quickSort(num, pivot + 1, right);
    }

    public static void quickSort(int[] num) {
        quickSort(num, 0, num.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 6, 2, 3456, 3, 4, 5, 0};
        int[] b = {1, -1, -5, 10, 2, -3, 6};
        int[] c = {-2, -1};
        int[] res = getMaxSubArray(c);
        quickSort(a);
        for (int n = 0; n < a.length; n++) {
            System.out.println(a[n]);
        }

        System.out.println("Max Val: " + res[2]);
        System.out.println("Starting from: " + res[0]);
        System.out.println("Ending at: " + res[1]);

    }


    /*
     *   Maximum sub-array
     *   [0] left
     *   [1] right
     *   [2] value
     */
    private static int[] getMaxSubArray(int[] a) {
        int max = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;
        int currentValue = 0;
        int currentLeft = -1;
        int currentRight = -1;

        for (int index = 0; index < a.length; index++) {
            //init left and right first
            if (currentLeft == -1) {
                currentLeft = index;
                currentRight = index;
            }
            //add current number
            currentValue += a[index];
            //handle max comparison
            if (currentValue > max) {
                max = currentValue;
                maxLeft = currentLeft;
                maxRight = currentRight;
            }
            //hand current values reset
            if (currentValue > 0) {
                currentRight = index;
            } else {
                currentLeft = -1;
                currentValue = 0;
            }

        }
        int[] res = new int[3];
        res[0] = maxLeft;
        res[1] = maxRight;
        res[2] = max;
        return res;
    }

}
