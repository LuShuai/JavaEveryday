package string;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 4/7/15.
 */
public class PlusMinusGame {

    public static List<Integer> getValidMoves(char[] ca) {
        List<Integer> list = new LinkedList<Integer>();
        if (ca == null || ca.length < 2) {
            return list;
        }
        for (int n = 0; n < ca.length-1; n++) {
            if (ca[n] == '-' && ca[n+1] == '-') {
                list.add(n);
            }
        }
        return list;
    }



    public static List<Integer> getWinningMoves(char[] ca) {
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> possibleMoves = getValidMoves(ca);
        if (possibleMoves.size() >= 1) {
            for (Integer startPoint : possibleMoves) {
                ca[startPoint] = '+';
                ca[startPoint+1] = '+';
                List<Integer> enemyMoves = getWinningMoves(ca);
                if (enemyMoves.size() == 0) {
                    list.add(startPoint);
                }
                ca[startPoint] = '-';
                ca[startPoint+1] = '-';
            }

        }
        return list;
    }




    public static List<Integer> getMustWinMoves(char[] ca) {
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> winningMoves = getWinningMoves(ca);
        if (winningMoves.size() >= 1) {
            for (Integer startPoint : winningMoves) {
                ca[startPoint] = '+';
                ca[startPoint+1] = '+';
                List<Integer> enemyMoves = getMustWinMoves(ca);
                if (enemyMoves.size() == 0) {
                    list.add(startPoint);
                }
                ca[startPoint] = '-';
                ca[startPoint+1] = '-';
            }
        }
        return list;
    }




    public static void main (String[] args) {
        String current = "------";
        char[] ca = current.toCharArray();
        List<Integer> winningPaths = getMustWinMoves(ca);
        System.out.println(winningPaths.toString());
        System.out.println();

    }
}
