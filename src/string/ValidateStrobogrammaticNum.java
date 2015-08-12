package string;

import java.util.HashMap;

/**
 * Created by shuailu on 8/10/15.
 */
public class ValidateStrobogrammaticNum {

    public static boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        int left = 0;
        int right = num.length() - 1;

        while (right >= left) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (right == left) {
                return leftChar == '8' || leftChar == '1';
            }
            if (!isNumChar(leftChar) || !isNumChar(rightChar)
                || !map.containsKey(leftChar) || map.get(leftChar) != rightChar) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private static boolean isNumChar(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void main (String[] args) {
        System.out.println(isStrobogrammatic("11"));
    }

}
