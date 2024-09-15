package first_and_last_in_array_34;

import java.util.Arrays;

class Solution {
    public int[] searchRange1(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0 || nums[index] != target) return new int[] {-1, -1};
        
        int[] results = { index, index };

        int i = index;
        while (i >= 0 && nums[i] == target) results[0] = i--;

        i = index;
        while (i < nums.length && nums[i] == target) results[1] = i++;

        return results;
    }

    private int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target, 0, nums.length-1);
        if (first == -1) return new int[] { -1, -1 };

        return new int[] { first, findLast(nums, target, first, nums.length-1) };
    }

    private int findFirst(int[] nums, int target, int left, int right) {
        int first = -1;
        while (left <= right) {
            var mid = left + (right - left)/2; // for overflow

            if (nums[mid] >= target) {
                if (nums[mid] == target) first = mid;

                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return first;
    }

    private int findLast(int[] nums, int target, int left, int right) {
        int last = left;
        while (left <= right) {
            var mid = left + (right - left)/2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) last = mid;

                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

}