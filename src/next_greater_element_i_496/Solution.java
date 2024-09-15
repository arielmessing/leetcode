package next_greater_element_i_496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreatest = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (! stack.isEmpty() && stack.peek() < num) {
                nextGreatest.put(stack.pop(), num);
            }

            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreatest.getOrDefault(nums1[i], -1);
        }

        return nums1;

        // return Arrays.stream(nums1)
        //     .map(num -> nextGreatest.getOrDefault(num, -1))
        //     .toArray();
    }
}