package dp;

import java.util.LinkedList;

/**
 * Created by shuailu on 6/7/16.
 *
 * 2 players adding numbers from (0, N], until the someone reached or exceeded the target number, and that player won.
 * numbers can not be reused
 */
public class OneHundredGame {

    public static boolean canWin(int maxChoosableNum, int targetTotal) throws Exception {

        if ((1 + maxChoosableNum) * maxChoosableNum / 2 < targetTotal) {
            throw new Exception("No one can win");
        }
        boolean[] usedNumbers = new boolean[maxChoosableNum];
        return canWin(maxChoosableNum, 0, targetTotal, usedNumbers);
    }

    private static boolean canWin(int maxChoosableNum, int currentTotal, int targetTotal, boolean[] used) {
        if (currentTotal >= targetTotal) {
            return true;
        }
        for (int n = maxChoosableNum; n > 0; n--) {
            if (!used[n - 1]) {
                used[n - 1] = true;
                if (!canWin(maxChoosableNum, currentTotal + n, targetTotal, used)) {
                    return true;
                }
                used[n - 1] = false;
            }
        }
        return false;
    }


    public static LinkedList<Integer> findWinningPath(int maxChoosableNum, int targetTotal) throws Exception {

        if ((1 + maxChoosableNum) * maxChoosableNum / 2 < targetTotal) {
            throw new Exception("No one can win");
        }
        boolean[] usedNumbers = new boolean[maxChoosableNum];
        return findWinningPath(targetTotal, usedNumbers, new LinkedList<Integer>());
    }

    private static LinkedList<Integer> findWinningPath(int targetTotal, boolean[] used, LinkedList<Integer> currentList) {
        System.out.println("looking for: " + targetTotal + "; currentList: " + currentList);
        if (targetTotal <= 0) {
            return currentList;
        }
        LinkedList<Integer> res = new LinkedList<>();
        for (int n = used.length; n > 0; n--) {
            if (!used[n - 1]) {
                used[n - 1] = true;
                currentList.addLast(n);
                if (findWinningPath(targetTotal - n, used, currentList).size() == 0) {
                    currentList.removeLast();
                    return currentList;
                }
                currentList.removeLast();
                used[n - 1] = false;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(findWinningPath(3, 5));
    }


}
