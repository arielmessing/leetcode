package remove_k_digits_402;

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        Stack<Character> monotonicStack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while (! monotonicStack.isEmpty() && 
                    monotonicStack.peek() > c && 
                    k > 0) {

                monotonicStack.pop();
                k--;
            }

            monotonicStack.push(c);
        }

        while (k > 0) {
            monotonicStack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean lastCharWasZero = false;

        while (! monotonicStack.isEmpty()) {
            char c = monotonicStack.pop();
            sb.append(c);

            lastCharWasZero = c == '0';
        }

        while (lastCharWasZero && sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);

            lastCharWasZero = sb.charAt(sb.length() - 1) == '0';
        }

        return sb.reverse().toString();
    }
}