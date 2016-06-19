package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuailu on 6/15/16.
 */
public class PhoneNumberLetterCombinations {


    private static ArrayList<ArrayList<Character>> init() {
        ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
        ArrayList<Character> key;
        for (int n = 0; n <= 9; n++) {
            key = new ArrayList<Character>();
            switch (n) {
                case 0:
                    key.add(' ');
                    break;
                case 1:
                    key.add('\0');
                    break;
                case 2:
                    key.add('a');
                    key.add('b');
                    key.add('c');
                    break;
                case 3:
                    key.add('d');
                    key.add('e');
                    key.add('f');
                    break;
                case 4:
                    key.add('g');
                    key.add('h');
                    key.add('i');
                    break;
                case 5:
                    key.add('j');
                    key.add('k');
                    key.add('l');
                    break;
                case 6:
                    key.add('m');
                    key.add('n');
                    key.add('o');
                    break;
                case 7:
                    key.add('p');
                    key.add('q');
                    key.add('r');
                    key.add('s');
                    break;
                case 8:
                    key.add('t');
                    key.add('u');
                    key.add('v');
                    break;
                case 9:
                    key.add('w');
                    key.add('x');
                    key.add('y');
                    key.add('z');
                    break;
                default:
                    break;
            }
            res.add(key);
        }
        return res;
    }


    public static ArrayList<String> letterCombinations(String digits) {


//        ArrayList<ArrayList<Character>> phone = init();
//        ArrayList<String> res = new ArrayList<String>();
//        if (digits.length() == 0) {
//            return res;
//        }
//        buildList("", digits, res, phone);
//        return res;

        return letterCombinations(digits, init(), new HashMap<String, ArrayList<String>>());
    }

    private static ArrayList<String> letterCombinations(String digits, ArrayList<ArrayList<Character>> map,
                                                        Map<String, ArrayList<String>> note) {

        ArrayList<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        ArrayList<String> saved = note.get(digits);
        if (saved != null) {
            System.out.println("fetching saved: " + digits + ", List size: " + saved.size());
            return saved;
        }
        System.out.println("checking digits: " + digits);

        ArrayList<String> subRes = letterCombinations(digits.substring(1), map, note);
        for (char firstChar : map.get(Integer.parseInt(digits.substring(0, 1)))) {

            if (subRes.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(firstChar);
                res.add(new String(sb));
                continue;
            }
            for (String suffix : subRes) {
                StringBuilder sb = new StringBuilder();
                sb.append(firstChar);
                sb.append(suffix);
                res.add(new String(sb));
            }
        }
        note.put(digits, res);
        return res;
    }


    public static void buildList(String combination, String digits, ArrayList<String> res,
                          ArrayList<ArrayList<Character>> phone) {

        if (digits.length() == 0) {
            res.add(combination);
            return;
        }

        ArrayList<Character> candidate = phone.get(Character.getNumericValue(digits.charAt(0)));
        for (Character c : candidate) {
            buildList(combination + c, digits.substring(1, digits.length()), res, phone);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        letterCombinations("343434343434343");
        long end = System.currentTimeMillis();

        System.out.println("cost: " + (end - start) / 1000 + " seconds");
    }


}
