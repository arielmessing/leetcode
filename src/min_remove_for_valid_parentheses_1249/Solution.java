package min_remove_for_valid_parentheses_1249;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> indicesToRemove = new HashSet<>();

        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == '(') {
                stack.push(i);

            } else if (sArr[i] == ')') {
                if (stack.isEmpty()) indicesToRemove.add(i);
                else stack.pop();
            }
        }

        indicesToRemove.addAll(stack);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; i++) {
            if (! indicesToRemove.contains(i)) sb.append(sArr[i]);
        }

        return sb.toString();
    }
}