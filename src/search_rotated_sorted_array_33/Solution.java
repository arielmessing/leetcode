package search_rotated_sorted_array_33;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0,
            right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (target == nums[mid]) return mid;

            if (nums[left] <= nums[mid]) {
                // Left sorted portion

                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }

            } else {
                // Right sorted portion

                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}