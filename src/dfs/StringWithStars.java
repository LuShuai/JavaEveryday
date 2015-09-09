package dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuailu on 9/8/15.
 * Given a string consists of only 1, 0 and *.
 * '*' could be either 0 or 1.
 * return a list of all possible strings
 */
public class StringWithStars {

    public static void main (String[] args) {
        String s1 = "1*0";
        String s2 = "**0";
        String s3 = "0**";
        String s4 = "***";
        String s5 = "01010101";
        String s6 = "0**1*1*1";
        String s7 = null;

        System.out.print(decode(s1));
        System.out.print(decode(s2));
        System.out.print(decode(s3));
        System.out.print(decode(s4));
        System.out.print(decode(s5));
        System.out.print(decode(s6));
        System.out.print(decode(s7));
    }

    public static List<String> decode(String s) {
        List<String> res = new LinkedList<String>();

        if (s == null || s.length() == 0) {
            return res;
        }

        decode(s, "", res);
        return res;
    }

    public static void decode(String s, String currentString, List<String> res) {
        int index = currentString.length();
        if (index == s.length()) {
            res.add(currentString);
            return;
        }
        char ch = s.charAt(index);
        if (ch == '*') {
            decode(s, currentString + '1', res);
            decode(s, currentString + '0', res);
        } else {
            decode(s, currentString + ch, res);
        }
    }

}
