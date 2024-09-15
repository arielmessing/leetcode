package kth_largest_in_array_215;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];

        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Comparator.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }
        
        int n = 0;
        for (int i = 0; i < k; i++) {
            n = pq.poll();
        }
        
        return n;
    }
}