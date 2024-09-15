package word_subsets_916;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> wordSubsets = new ArrayList<>();

        int[] maxCharFrequencies = new int[26];

        for (String word : words2) {
            int[] frequencies = getCharFrequencies(word);

            setMaxCharFrequencies(maxCharFrequencies, frequencies);
        }

        for (String word : words1) {
            if (isSubset(word, maxCharFrequencies)) {
                wordSubsets.add(word);
            }
        }

        return wordSubsets;
    }

    private int[] getCharFrequencies(String word) {
        int[] frequencies = new int[26];

        for (char c : word.toCharArray()) {
            frequencies[c - 'a']++;
        }

        return frequencies;
    }

    private void setMaxCharFrequencies(int[] maxCharFrequencies, int[] frequencies) {
        for (int i = 0; i < maxCharFrequencies.length; i++) {
            maxCharFrequencies[i] = Math.max(maxCharFrequencies[i], frequencies[i]);
        }
    }

    private boolean isSubset(String word, int[] maxCharFrequencies) {
        int[] frequencies = getCharFrequencies(word);

        for (int i = 0; i < maxCharFrequencies.length; i++) {
            if (maxCharFrequencies[i] != 0 && maxCharFrequencies[i] > frequencies[i])
                return false;
        }

        return true;
    }
}