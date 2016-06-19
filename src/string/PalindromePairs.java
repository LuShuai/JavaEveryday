package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by shuailu on 6/13/16.
 */
public class PalindromePairs {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int n = 0; n < words.length; n++) {
            map.put(words[n], n);
        }

        for (int current = 0; current < words.length; current++) {
            String word = words[current];
            for (int split = 1; split <= word.length(); split++) {
                String left = word.substring(0, split);
                String right = word.substring(split, word.length());

                if (isPalindrome(left)) {
                    String targetRight = new StringBuilder(right).reverse().toString();
                    Integer index = map.get(targetRight);
                    if (index != null && index != current) {
                        List<Integer> list = new LinkedList<>();
                        list.add(index);
                        list.add(current);
                        res.add(list);
                        if (targetRight.length() == 0) {
                            list = new LinkedList<>();
                            list.add(current);
                            list.add(index);
                            res.add(list);
                        }
                    }
                }
                if (isPalindrome(right)) {
                    Integer index = map.get(new StringBuilder(left).reverse().toString());
                    if (index != null && index != current) {
                        List<Integer> list = new LinkedList<>();
                        list.add(current);
                        list.add(index);
                        res.add(list);
                    }
                }
            }
        }
        return res;


    }


    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"a", ""}));
        System.out.println(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }

}
