package someTest;

import java.util.HashMap;

/**
 * Created by shuailu on 4/10/15.
 */
public class StairsCal {

    private static void getWays(int stairNum, int stepNum, int[] count, HashMap<Integer, Integer> noteBook) {
        if (stairNum == 0) {
            count[0] ++;
            return;
        }
        Integer key = stepNum * 100 + stairNum;
        if (noteBook.containsKey(key)) {
            count[0] += noteBook.get(key);
            return;
        }

        for (int step = 1; step <= stepNum; step ++) {
            if (step <= stairNum) {
                getWays(stairNum - step, stepNum, count, noteBook);
            }
        }
        noteBook.put(key, count[0]);
    }

    public static int getWays(int stairNum, int stepNum) {
        int[] count = new int[1];
        count[0] = 0;
        HashMap<Integer, Integer> noteBook = new HashMap<Integer, Integer>();
        getWays(stairNum, stepNum, count, noteBook);
        return count[0];
    }

    public static void main(String[] args) {
        System.out.println(getWays(32, 2));
    }
}
