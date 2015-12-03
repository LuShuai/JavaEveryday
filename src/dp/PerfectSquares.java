package dp;

/**
 * Created by shuailu on 9/15/15.
 */
public class PerfectSquares {

    public static int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] note = new int[n + 1];
        note[0] = 0;
        note[1] = 1;
        for (int i = 2; i < note.length; i++) {
            note[i] = -1;
        }
        return numSquares(n, note);
    }

    private static int numSquares(int n, int[] note) {
        if (note[n] != -1) {
            return note[n];
        }
        System.out.println("Need real calc:" + n);

        int min = n;
        double target = (double) n;
        for (int left = (int) Math.sqrt(target); left > 0; left--) {

            int val = 1 + numSquares(n - (left * left), note);
            min = min < val ? min : val;
        }
        note[n] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(48));
    }

}
