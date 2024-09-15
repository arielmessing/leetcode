package permutations_46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new LinkedList<>();
        for (int num : nums) numsList.add(num);

        List<List<Integer>> results = permute(numsList);

        return results;        
    }

    private List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums.size() == 1) {
            results.add(new ArrayList<>(nums)); // ???
        
        } else {
            for (int i = 0; i < nums.size(); i++) {
                int n = nums.removeFirst();
                
                List<List<Integer>> perms = permute(nums);
                for (List<Integer> perm : perms) perm.addLast(n);

                results.addAll(perms);

                nums.addLast(n);
            }
        }

        return results;
    }
}