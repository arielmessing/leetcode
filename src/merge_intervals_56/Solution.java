package merge_intervals_56;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        Stack<int[]> merged = new Stack<>();
        merged.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] top = merged.peek();

            if (current[0] > top[1]) {
                merged.push(current);

            } else if (current[1] > top[1]) {
                top[1] = current[1];
            }
        }

        int[][] results = new int[merged.size()][2];
        for (int i = merged.size() - 1; i >= 0; i--) {
            results[i] = merged.pop();
        }

        return results;
    }
}