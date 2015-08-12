package string;

/**
 * Created by shuailu on 8/11/15.
 */

import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
**/


public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int n = 0; n < s.length(); n++) {
            char ch = s.charAt(n);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != getLeftSide(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static char getLeftSide(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else if (c == '}') {
            return '{';
        } else {
            return '\0';
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()()"));   //t
        System.out.println(isValid("()()[]{}")); //t
        System.out.println(isValid("[(())]{}")); //t
        System.out.println(isValid("[({)(})]")); //f
        System.out.println(isValid("[")); //f

    }

}
