package someTest;

/**
 * Created by Shuai Lu on 10/18/16.
 * <p>
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 */
public class FindLIS {

    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    private static int ceilIndex(int A[], int left, int right, int key) {
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] >= key) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private static int longestIncreasingSubsequenceLength(int A[], int size) {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0]) {
                // new smallest value
                tailTable[0] = A[i];
            } else if (A[i] > tailTable[len - 1]) {
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
            } else {
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[ceilIndex(tailTable, -1, len - 1, A[i])] = A[i];
            }
        }

        return len;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int A[] = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        int n = A.length;

        System.out.println(ceilIndex(new int[]{2, 5}, -1, 1, 2));

        System.out.println("Length of Longest Increasing Subsequence is " +
                longestIncreasingSubsequenceLength(A, n));
    }
    // Main method to test.
//    public static void main(String[] args) {
//        // Test data: {2, 1, 6, 3, 5, 4, 8, 7, 9}.
//        int[] givenArray = {2, 1, 6, 3, 5, 4, 8, 7, 9};
//        //int[] givenArray = {1, 2, 1, 4, 5, 3, 10};
//        //int[] givenArray = {2, 1, 6, 3, 5, 4, 8, 7, 9};
//
//        // Test finding the LIS by DP + Binary search.
//        System.out.println("Test finding the LIS by DP + Binary search, max len = " + findLISLen(givenArray));
//
//    }
}
