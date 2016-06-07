package someTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        System.out.println("target: " + money + ", index: " + index);
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


    private static List<LinkedList<Integer>> findPlans(int[] prices, int money, int index,
                                                       Map<Integer, Map<Integer, List<LinkedList<Integer>>>> note) {
        //System.out.println("finding target: " + money + ", index: " + index);
        //note is a index --> money --> result map
        Map<Integer, List<LinkedList<Integer>>> money2ResultMap = note.get(index);
        if (money2ResultMap != null) {
            List<LinkedList<Integer>> res = money2ResultMap.get(money);
            if (res != null) {
                System.out.println("fetching from map money :" + money + ", index: " + index + ", list:" + res);
                return new LinkedList<>(res);
            }
        }

        List<LinkedList<Integer>> res = new LinkedList<>();
        if (index < 0 || index >= prices.length) {
            return res;
        }

        if (prices[index] == money) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(prices[index]);
            res.add(list);
            saveToMap(money, index, note, res);
            return res;
        } else if (prices[index] < money) {
            //buy and stay
            List<LinkedList<Integer>> buyAndStay = findPlans(prices, money - prices[index], index, note);
            //just go
            List<LinkedList<Integer>> go = findPlans(prices, money, index + 1, note);
            List<LinkedList<Integer>> buyAndStayNew = new LinkedList<>();
            if (!buyAndStay.isEmpty()) {
                for (LinkedList<Integer> list : buyAndStay) {
                    LinkedList<Integer> newList = new LinkedList<>(list);
                    newList.addFirst(prices[index]);
                    buyAndStayNew.add(newList);
                }
                res.addAll(buyAndStayNew);
            }
            if (!go.isEmpty()) {
                res.addAll(go);
            }

            saveToMap(money, index, note, res);
            return res;
        } else {
            saveToMap(money, index, note, res);
            return res;
        }

    }

    private static void saveToMap(int money, int index, Map<Integer, Map<Integer, List<LinkedList<Integer>>>> note,
                                  List<LinkedList<Integer>> list) {
        System.out.println("saving to map money :" + money + ", index: " + index + ", list:" + list);
        Map<Integer, List<LinkedList<Integer>>> money2ResultMap = note.get(index);
        if (money2ResultMap == null) {
            money2ResultMap = new HashMap<>();
        }
        money2ResultMap.put(money, new LinkedList<>(list));
        note.put(index, money2ResultMap);
    }


    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3};
        System.out.println(findPlans(prices, 15, 0, new HashMap<Integer, Map<Integer, List<LinkedList<Integer>>>>()));
    }
}
