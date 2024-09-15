package sort_colors_75;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0,
            right = nums.length - 1,
            current = 0;

        while (left < right && current <= right) {
            if (nums[current] == 0) {
                nums[current] = nums[left];
                nums[left] = 0;
                left++;
                current++;

            } else if (nums[current] == 2) {
                nums[current] = nums[right];
                nums[right] = 2;
                right--;

            } else {
                current++;
            }
        }
    }
}