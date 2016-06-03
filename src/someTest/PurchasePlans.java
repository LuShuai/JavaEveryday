package someTest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 6/2/16. Given an int[] prices, as all prices of stuffs and the amount of money you have. Find
 * all purchase plans to spend all your money. Example: Prices: [1, 6 , 12], money you have: 12 output:
 * {{0,0,0,0,0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,1}, {1,1}, {2}}
 */
public class PurchasePlans {

    public static List<List<Integer>> findPlans(int[] prices, int money) {
        List<List<Integer>> res = new LinkedList<>();
        if (prices == null || prices.length < 1 || money <= 0) {
            return res;
        }
        // findPlans into res;
        findPlans(prices, money, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private static void findPlans(int[] prices, int money, int index, LinkedList<Integer> currentList,
                           List<List<Integer>> res) {
        if (index > prices.length || money < 0) {
            return;
        }
        if (0 == money) {
            res.add(new LinkedList<>(currentList));
            return;
        }
        for (int n = index; n < prices.length; n++) {
            if (money >= prices[n]) {
                currentList.add(n);
                findPlans(prices, money - prices[n], n, currentList, res);
                currentList.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 6, 12};

        //prices = new int[]{6, 12, 6};
        System.out.println(findPlans(prices, 12));
    }
}
