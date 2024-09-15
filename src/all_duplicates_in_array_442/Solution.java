package all_duplicates_in_array_442;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] < 0) {
                duplicates.add(index + 1);
            }

            nums[index] *= -1;
        }

        return duplicates;
    }
}