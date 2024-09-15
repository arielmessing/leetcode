package contiguous_array_525;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int zeroes = 0, ones = 0;

        Map<Integer, Integer> endIndexByDiff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (n == 0) zeroes++;
            else ones++;

            if (! endIndexByDiff.containsKey(ones - zeroes)) {
                endIndexByDiff.put(ones - zeroes, i);
            }

            if (ones == zeroes) {
                res = ones + zeroes;

            } else {
                int endIndex = endIndexByDiff.get(ones - zeroes);
                res = Math.max(res, i - endIndex);
            }
        }

        return res;
    }
}