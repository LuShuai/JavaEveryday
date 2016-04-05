package string;

/**
 * Created by shuailu on 12/9/15.
 */
public class URegexMatch {

    private static boolean debug = false;

    public static void main(String[] args) {
        System.out.println(isMatch("aaaabc", "a{0,15}b{0,1}c"));

    }

    public static boolean isMatch(String s, String p) {
        if (debug) {
            System.out.println("testing :" + s + " " + p);
        }
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }

        if (p.length() < 2) {
            return !(s == null || s.length() == 0) && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(
                s.substring(1), p.substring(1));
        }

        if (p.charAt(1) == '{') {

            String[] split = p.substring(2).split("}");
            String[] range = split[0].split(",");
            String rest = p.substring(3 + split[0].length());

            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);

            if (s.length() == 0) {
                return isMatch("", rest);
            }

            if (start == 0 && isMatch(s, rest)) {
                 return true;
            }
            start = start == 0 ? 1 : start;
            for (int n = start; n <= end && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && n < s.length(); n++) {
                if (isMatch(s.substring(n), rest)) {
                    return true;
                }
            }
            return false;
        } else {
            return !(s == null || s.length() == 0) && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(
                s.substring(1), p.substring(1));
        }
    }


}

