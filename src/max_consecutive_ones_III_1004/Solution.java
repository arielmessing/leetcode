package max_consecutive_ones_III_1004;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, max = 0, current = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) 
                current++;
            

            while (current > k) {
                if (nums[left] == 0) 
                    current--;
                
                left++;
            }

            if (current <= k)
                max = Math.max(max, right-left+1);
        }

        return max;
    }
}