package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shuailu on 11/18/15.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return pattern == null && str == null;
        }

        

        String[] patterns = pattern.split("");
        String[] strs = str.split(" ");
        if (patterns.length != strs.length) {
            return false;
        }
        Map<String, String> dict = new HashMap<String, String>();
        Set<String> recordedTarget = new HashSet<String>();
        for (int n = 0; n < patterns.length; n++) {
            String target = strs[n];
            String origin = patterns[n];
            if (!dict.containsKey(origin)) {
                if (recordedTarget.contains(target)) {
                    return false;
                }
                dict.put(origin, target);
                recordedTarget.add(target);
            } else {
                if (!dict.get(origin).equals(target)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("", "beef"));
    }

}
