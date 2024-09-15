package remove_start_from_string_2390;

import java.util.ArrayDeque;

class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (! result.isEmpty()) result.deleteCharAt(result.length() - 1);

            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public String removeStarsWStack(String s) {
        var stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (! stack.isEmpty()) stack.pop();

            } else {
                stack.push(s.charAt(i));
            }
        }

        var result = new StringBuilder();
        while (! stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}