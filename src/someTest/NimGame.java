package someTest;

import java.util.HashMap;

/**
 * Created by shuailu on 10/15/15.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        return canWinNim(n, map);
    }

    private boolean canWinNim(int n, HashMap<Integer, Boolean> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        boolean anyWin = false;
        if (n <= 3) {
            return true;
        }
        for (int i = 3; i >= 1; i--) {
            anyWin = anyWin || !canWinNim(n - i, map);
        }
        map.put(n, anyWin);
        return anyWin;
    }


    public static void main(String[] args) {
        NimGame nimGame = new NimGame();
        System.out.println(nimGame.canWinNim(1348820612));
    }
}
