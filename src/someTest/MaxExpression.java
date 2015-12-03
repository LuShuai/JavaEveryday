package someTest;

/**
 * Created by shuailu on 10/29/15.
 *
 * Given an array, find the max vale by making it an expression with only +, *, (, ) Example: 3, 1, 1, 6 Should return:
 * 36        [ 36 = 3 * (1 + 1) * 6 ]
 */
public class MaxExpression {

    public static int findMax(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[][] map = new int[len][len];
        for (int n = 0; n < len; n++) {
            for (int m = 0; m < len; m++) {
                map[n][m] = Integer.MIN_VALUE;
            }
        }
        return findMax(arr, 0, len - 1, map);
    }

    //TODO: need to do boulder check and start/end index check in outer function
    //TODO: build map with all INTEGER.MIN_VALUE
    private static int findMax(int[] arr, int start, int end, int[][] map) {
        System.out.println("calculating max from [" + start + "] to [" + end + "]");
        if (start == end) {
            return arr[start];
        } else if (start > end) {
            throw new RuntimeException("Should not reach here");
        } else if (end - start == 1) {
            int sum = arr[start] + arr[end];
            int mult = arr[start] * arr[end];
            return sum > mult ? sum : mult;
        } else {
            if (map[start][end] != Integer.MIN_VALUE) {
                return map[start][end];
            }
            for (int newStart = start; newStart < end; newStart++) {
                int left = findMax(arr, start, newStart, map);
                int right = findMax(arr, newStart + 1, end, map);
                int sum = left + right;
                int mult = left * right;
                int currentMax = (sum > mult ? sum : mult);
                map[start][end] = currentMax > map[start][end] ? currentMax : map[start][end];
            }
            return map[start][end];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 1, 1, 6, 1, 1, 5};
        System.out.println("result is: " + findMax(arr));
    }

}
