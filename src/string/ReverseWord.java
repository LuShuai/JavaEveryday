package string;

/**
 * Created by shuailu on 8/5/15.
 */
public class ReverseWord {

    public static void reverseWords(char[] s) {
        reverseSub(s, 0, s.length - 1);
        int left = 0;
        int right = s.length - 1;

        int point = 0;
        while (point < s.length) {
            //look for the next non-space char
            while (point < s.length && Character.isSpaceChar(s[point])) {
                point++;
            }
            left = point++;
            //look for the next space
            while (point < s.length && !Character.isSpaceChar(s[point])) {
                point++;
            }
            right = point++;
            reverseSub(s, left, right - 1);
        }


    }

    //left and right elements are both INCLUSIVE
    private static void reverseSub(char[] s, int left, int right) {
        if (left < 0 || right >= s.length) {
            return;
        }
        while (right > left) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] ca = "a b".toCharArray();

        reverseWords(ca);
        System.out.println(new String(ca));
    }


}
