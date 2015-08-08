package string;

import java.util.HashMap;

/**
 * Created by shuailu on 8/6/15.
 */
public class LongestStringWithoutRepeatingLetters {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        int currentLength = 0;
        int lastDeletedIndex = -1;
        for (int n = 0; n < s.length(); n++) {
            char ch = s.charAt(n);
            if (indexMap.containsKey(ch)) {
                //handle same
                int index = indexMap.get(ch);
                currentLength = n - index;
                for (int i = index; i > lastDeletedIndex; i--) {
                    indexMap.remove(s.charAt(i));
                }
                lastDeletedIndex = index;
            } else {
                //handle diff
                ++currentLength;
                maxLength = currentLength > maxLength ? currentLength : maxLength;
            }
            indexMap.put(s.charAt(n), n);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt2435890"));
        System.out.println("tmmzuxt2435890".length() - 2);
    }

}
