package combinations_77;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), results);
        return results;
    }

    // Backtracking
    private void combine(
        int n, 
        int k, 
        int start, 
        List<Integer> combination,
        List<List<Integer>> results) {

            if (combination.size() == k) {
                results.add(new ArrayList<>(combination));
                return;
            }

            for (int i = start; i <= n; i++) {
                combination.add(i);
                combine(n, k, i + 1, combination, results);
                combination.removeLast();
            }
        }
}