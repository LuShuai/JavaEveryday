package dp;

/**
 * Created by shuailu on 4/27/16.
 * Longest increasing sequence
 */

public class LIS {

    public static int getLIS(int[] arr) {
        if (arr == null || arr.length != 0) {
            return 0;
        }

        int[] max = new int[1];
        int[] note = new int[arr.length];
        for (int n = 0; n < note.length; n++) {
            note[n] = 1;
        }
        max[0] = 0;
        for (int n = arr.length - 1; n >= 0; n--) {
            getLIS(arr, note, max, n);
        }
        return max[0];
    }

    private static int getLIS(int[] arr, int[] note, int[] max, int current) {
//        if (note[]) {
//
//        }
        return -1;
    }
}
