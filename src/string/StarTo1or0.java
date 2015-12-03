package string;

import java.util.LinkedList;

public class StarTo1or0 {

    public static LinkedList<String> fillStars1(String s) {
        LinkedList<String> res = new LinkedList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        fillHelper(s.toCharArray(), 0, res);
        return res;
    }

    private static void fillHelper(char[] s, int current, LinkedList<String> res) {
        if (current == s.length) {
            res.add(new String(s));
            return;
        }
        while (current < s.length && s[current] != '*') {
            ++current;
        }

        if (current == s.length) {
            res.add(new String(s));
        } else {
            s[current] = '0';
            fillHelper(s, current + 1, res);
            s[current] = '1';
            fillHelper(s, current + 1, res);
            s[current] = '*';
        }
    }

    public static LinkedList<String> fillStars2(String s) {
        LinkedList<String> res = new LinkedList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        LinkedList<Integer> positions = new LinkedList<Integer>();
        char[] ca = s.toCharArray();
        for (int n = 0; n < s.length(); n++) {
            if (s.charAt(n) == '*') {
                positions.add(n);
            }
        }
        int max = (int) Math.pow(2, positions.size()) - 1;
        for (int n = 0; n <= max; n++) {
            for (int p = positions.size() - 1; p >= 0; p--) {
                ca[positions.get(p)] = (char) (((n >> (positions.size() - 1 - p)) & 1) + '0');
            }
            res.add(new String(ca));
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<String> res = fillStars2("*1");

        for (String s : res) {
            System.out.println(s);
        }
        System.out.println("number:" + res.size());
    }

}
