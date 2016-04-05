package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuailu on 2/11/16.
 */
public class LongestStringChain {
    public static int getMaxLength(List<String> strs) {

        HashMap<String, Integer> note = new HashMap<String, Integer>();
        for (String str : strs) {
            note.put(str, -1);
        }

        for (String str : strs) {
            note.put(str, getLength(str, note));
        }

        int max = 0;
        for (HashMap.Entry<String, Integer> entry : note.entrySet()) {
            int val = entry.getValue();
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    private static int getLength(String str, HashMap<String, Integer> note) {
        System.out.println("Getting length of: " + str);
        int notedLength = note.get(str);

        if (notedLength != -1) {
            System.out.println("(skipped)");
            return notedLength;
        }
        if (str.length() == 1) {
            note.put(str, 1);
            return 1;
        }
        int max = 0;
        for (int n = 0; n < str.length(); n++) {
            String subString = removeCharAt(str, n);
            if (note.keySet().contains(subString)) {
                int length = 1 + getLength(subString, note);
                if (length > max) {
                    max = length;
                }
            }
        }
        note.put(str, max);
        return max;
    }

    private static String removeCharAt(String str, int index) {
        return new StringBuilder(str).deleteCharAt(index).toString();
    }

    public static void main(String[] args) {
        //String[] strs = {"a", "abcd", "bcd", "cd", "c"};
        String[] strs = {"bdca", "a", "b", "ba", "bca", "bda"};
        System.out.println(getMaxLength(Arrays.asList(strs)));
    }
}
