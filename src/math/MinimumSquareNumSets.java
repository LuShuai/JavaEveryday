package math;

/**
 * Created by shuailu on 8/4/15.
 */
//find the minimum set of numbers that are squares of a integer and can add up to the given number.
//ex: 13 = 2^2 + 3^2   --> return 2

public class MinimumSquareNumSets {

    public static int getMinimumSetNum(int num) {
        int[] note = new int[num];
        for (int n = 0; n < note.length; n++) {
            note[n] = -1;
        }
        return getMinimumSetNum(num, note);
    }

    public static int getMinimumSetNum(int num, int[] note) {
        if (num == 0) {
            return 0;
        }
        if (note[num - 1] != -1) {
            return note[num - 1];
        }
        if (num <= 0) {
            return -1;
        }
        if (num == 1) {
            note[num - 1] = 1;
            return 1;
        }
        int max = (int) Math.floor(Math.sqrt(num));
        int min = num;
        for (int off = 1; off <= max; off++) {
            min = Math.min(min, getMinimumSetNum(num - (off * off), note) + 1);
        }
        note[num - 1] = min;
        return note[num - 1];
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 20; n++) {
            System.out.println(n + "\t:\t" + getMinimumSetNum(n));
        }
    }
}
