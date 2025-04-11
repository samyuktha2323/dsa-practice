package dsa;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char charAtIndex = s.charAt(i);
            if (charAtIndex == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek()); 
                }
            }
        }

        return maxLength;
    }
}