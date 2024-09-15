package next_greater_element_ii_503;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, -1);

        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < n * 2; i++) {
            while (! indexStack.isEmpty() && 
                nums[indexStack.peek()] < nums[i % n]) {

                nextGreater[indexStack.pop()] = nums[i % n];
            }

            if (i < n)
                indexStack.push(i);
        }

        return nextGreater;
    }
}