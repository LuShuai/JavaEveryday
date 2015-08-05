package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shuailu on 8/5/15.
 */
public class QS {

    //place the equal numbers left
    private static int partition1(int[] num, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }

        Random random = new Random();
        int index = left + random.nextInt(right - left + 1);
        int pivot = left;
        swap(num, left++, index);
        while (left < right) {
            while (left < right && num[left] <= num[pivot]) {
                ++left;
            }
            while (left < right && num[right] > num[pivot]) {
                --right;
            }
            if (left < right) {
                swap(num, left, right);
                ++left;
                --right;
            }
        }
        if (num[left] <= num[pivot]) {
            swap(num, left, pivot);
            return left;
        } else {
            swap(num, left - 1, pivot);
            return left - 1;
        }
    }

    //place the equal numbers right
    private static int partition2(int[] num, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }

        Random random = new Random();
        int index = left + random.nextInt(right - left + 1);
        int pivot = left;
        swap(num, pivot, index);
        left++;
        while (left < right) {
            while (left < right && num[right] >= num[pivot]) {
                --right;
            }
            while (left < right && num[left] < num[pivot]) {
                ++left;
            }
            if (left < right) {
                swap(num, left, right);
                left++;
                right--;
            }
        }
        if (num[right] < num[pivot]) {
            swap(num, right, pivot);
            return right;
        } else {
            swap(num, right - 1, pivot);
            return right - 1;
        }
    }

    private static void swap(int[] a, int left, int right) {
        if (left != right) {
            a[left] = a[left] ^ a[right];
            a[right] = a[left] ^ a[right];
            a[left] = a[left] ^ a[right];
        }
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = partition2(a, left, right);
            quickSort(a, left, pivot - 1);
            quickSort(a, pivot + 1, right);
        }
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }


    public static int findKthSmallestNum(int[] num, int k, int left, int right) {
        if (num == null || k > num.length || k > right - left + 1) {
            return Integer.MIN_VALUE;
        }

        int index = partition1(num, left, right);
        if (index + 1 - left == k) {
            return num[index];
        } else if (index + 1 - left > k) {
            return findKthSmallestNum(num, k, left, index - 1);
        } else {
            return findKthSmallestNum(num, k - (index + 1 - left), index + 1, right);
        }
    }

    public static int findKthSmallestNum(int[] num, int k) {
        return findKthSmallestNum(num, k, 0, num.length - 1);
    }


    public static void main(String[] args) {
        //int[] a = {1, 6, 9, 3, 6, 9, 3};
        //int[] a = {1, 1, 1, 1, 1, 1, 1};
        int[] a = {3, 2, 1, 3, 6, 9, 1};
        //int pivot = partition1(a, 0, a.length - 1);
        quickSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(findKthSmallestNum(a, 4));
    }
}
