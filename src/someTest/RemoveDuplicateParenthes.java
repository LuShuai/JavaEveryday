package someTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shuailu on 11/4/15.
 */
public class RemoveDuplicateParenthes {

    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();

        // sanity check
        if (s == null) {
            return res;
        }

        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) {
                continue;
            }

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    // helper function checks if string s contains valid parantheses
    static boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            if (c == ')' && count-- == 0) {
                return false;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        List<String> res = removeInvalidParentheses("()())()");

        for (String s : res) {
            System.out.println(s);
        }
    }

}
