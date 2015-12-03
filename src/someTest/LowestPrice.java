package someTest;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by shuailu on 12/2/15.
 */
public class LowestPrice {
    public static int buyThemAll(Integer[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        List<HashMap.Entry<Integer, Integer>> groupedList = groupPrices(prices);
        return buyThemAll(groupedList);
    }

    public static int buyThemAll(List<HashMap.Entry<Integer, Integer>> toBuy) {
        printList(toBuy);
        if (toBuy == null || toBuy.isEmpty()) {
            return 0;
        }

        int largestPrice = toBuy.get(0).getKey();
        int largestNum = toBuy.get(0).getValue();
        int currentAmount = (largestNum * largestPrice);
        if (toBuy.size() == 1) {
            return currentAmount;
        }
        int secondPrice = toBuy.get(1).getKey();
        int secondNum = toBuy.get(1).getValue();
        int secondTotal = secondPrice * secondNum;

        //amount if buy second largest as well
        System.out.println("Skip " + largestNum + " " + largestPrice + "s");
        int amountIfBuyOne = buyThemAll(removeNLargestPrices(toBuy, largestNum * 2));
        int amountIfBuyTwo = buyThemAll(removeNLargestPrices(toBuy, (largestNum + secondNum) * 2));

        currentAmount = currentAmount + Math.min(amountIfBuyOne, amountIfBuyTwo + secondTotal);
        return currentAmount;
    }

    private static List<HashMap.Entry<Integer, Integer>> removeNLargestPrices(List<HashMap.Entry<Integer, Integer>> toBuy, int n) {
        List<HashMap.Entry<Integer, Integer>> copy = new LinkedList<Map.Entry<Integer, Integer>>();
        for (HashMap.Entry<Integer, Integer> entry : toBuy) {
            copy.add(new AbstractMap.SimpleEntry<Integer, Integer>(entry.getKey(), entry.getValue()));
        }

        while (n > 0 && copy.size() > 0) {
            HashMap.Entry<Integer, Integer> currentLevel = copy.get(0);
            if (currentLevel.getValue() > n) {
                currentLevel.setValue(currentLevel.getValue() - n);
                return copy;
            }
            n = n - currentLevel.getValue();
            copy.remove(0);
        }
        return copy;
    }



    private static LinkedList<HashMap.Entry<Integer, Integer>> groupPrices(Integer[] prices) {
        Arrays.sort(prices, Collections.reverseOrder());
        LinkedList<HashMap.Entry<Integer, Integer>> list = new LinkedList<HashMap.Entry<Integer, Integer>>();
        int currentPrice = prices[0];
        list.add(getEntry(currentPrice, 1));
        for (int n = 1; n < prices.length; n++) {
            int price = prices[n];
            if (currentPrice == price) {
                list.getLast().setValue(list.getLast().getValue() + 1);
            } else {
                currentPrice = price;
                list.addLast(getEntry(price, 1));
            }
        }
        return list;
    }


    public static HashMap.Entry<Integer, Integer> getEntry(int price, int num) {
        return new AbstractMap.SimpleEntry<Integer, Integer>(price, num);
    }


    public static void main(String[] args) {
//        System.out.println(buyThemAll(new Integer[] {5, 4, 3, 3})); // should be9
        System.out.println(buyThemAll(new Integer[] {6, 5, 4, 3, 3, 3})); // should be9
//        System.out.println(buyThemAll(new Integer[] {100, 99, 98, 1, 1, 1 })); //should be 200
//        System.out.println(buyThemAll(new Integer[] {100, 99, 98, 98, 98, 98, 97, 96})); //should be 395
    }

    private static void printList(List<HashMap.Entry<Integer, Integer>> list) {
        System.out.println("Elements in list");
        for (HashMap.Entry<Integer, Integer> entry : list) {
            System.out.print("price: " + entry.getKey() + ",  number" + entry.getValue());
            System.out.println("\t");
        }
    }

}
