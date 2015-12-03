package string;

/**
 * Created by shuailu on 11/28/15. '.' Matches any single character. '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 *
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true isMatch("aaa","aa") → false isMatch("aa", "a*") →
 * true isMatch("aa", ".*") → true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 */
public class RegexMatching {
    public static final boolean DEBUG = true;
    //assume s and p are not null;
    public static boolean isMatch(String s, String p) {
        if (DEBUG) {
            System.out.println("Testing isMatch: " + s + ", " + p);
        }
        //pattern runs out
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1) {
            return equalRest(s, p);
        }

        if (p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            for (int offset = 0; offset < s.length() && (s.charAt(offset) == p.charAt(0) || p.charAt(0) == '.'); offset++) {
                if (isMatch(s.substring(offset + 1), p.substring(2))) {
                    return true;
                }
            }
            return false;
        } else {
            return equalRest(s, p);
        }
    }

    private static boolean equalRest(String s, String p) {
        return s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
    }


    public static void main(String[] args) {
//        System.out.println(isMatch("aaab", ".*b"));   //true
//        System.out.println(isMatch("b", ".*b"));      //true
//        System.out.println(isMatch("aac", "b"));    //false
//        System.out.print(isMatch("b", "a*b"));      //true
        //System.out.println(isMatch("aa", "a*"));

        String test = "abcde";
        for (int n = 0; n <= test.length(); n++) {
            System.out.println("n: " + n);
            System.out.println(test.substring(n));
            System.out.println("");
        }
    }


}
