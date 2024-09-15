package longest_repeat_char_replace_424;

class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        
        int[] charactersCount = new int[26];
        int maxCount = 0;

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            charactersCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charactersCount[s.charAt(right) - 'A']);

            while (windowLength(right, left) - maxCount > k) {
                charactersCount[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, windowLength(right, left));
        }

        return maxLength;
    }

    private int windowLength(int right, int left) {
        return right - left + 1;
    }
}