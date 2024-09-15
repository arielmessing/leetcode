package combination_sum_39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        combine(candidates, target, 0, new ArrayList<>(), results);
        return results;        
    }

    private void combine(
        int[] candidates, 
        int target, 
        int start, 
        List<Integer> combination,
        List<List<Integer>> results) {
            int sum = sum(combination);
            
            if (sum > target) return;

            if (sum == target) {
                results.add(new ArrayList<>(combination));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                combination.add(candidates[i]);
                combine(candidates, target, i, combination, results);
                combination.removeLast();
            }
        }

    private int sum(List<Integer> combination) {
        int sum = 0;
        for (int num : combination) sum += num;
        return sum;
    }
}