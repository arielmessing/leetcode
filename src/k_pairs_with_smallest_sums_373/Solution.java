package k_pairs_with_smallest_sums_373;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(
                Comparator.comparingInt(pair -> (nums1[pair.get(0)] + nums2[pair.get(1)]))

                /*
                (pair1, pair2) ->
                (nums1[pair1.get(0)] + nums2[pair1.get(1)]) - (nums1[pair2.get(0)] + nums2[pair2.get(1)])
                 */
        );

        Set<List<Integer>> visited = new HashSet<>();

        int i = 0, j = 0;

        heap.add(List.of(i, j));
        visited.add(List.of(i, j));

        while (! heap.isEmpty() && k > 0) {
            List<Integer> top = heap.remove();

            i = top.get(0);
            j = top.get(1);
            res.add(List.of(nums1[i], nums2[j]));
            k--;

            var nextPair = List.of(i + 1, j);
            if (i + 1 < nums1.length && ! visited.contains(nextPair)) {
                heap.add(nextPair);
                visited.add(nextPair);
            }

            nextPair = List.of(i, j + 1);
            if (j + 1 < nums2.length && ! visited.contains(nextPair)) {
                heap.add(nextPair);
                visited.add(nextPair);
            }
        }

        return res;
    }
}