package partition_labels_763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> results = new ArrayList<>();

        int[] lastIndex = new int[26];

        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];

            lastIndex[c - 'a'] = i;
        }

        int size = 0;
        int end = 0;

        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];

            size++;
            end = Math.max(end, lastIndex[c - 'a']);

            if (i == end) {
                results.add(size);
                size = 0;
            }
        }

        return results;
    }
}