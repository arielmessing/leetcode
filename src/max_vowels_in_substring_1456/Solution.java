package max_vowels_in_substring_1456;

class Solution {
    public int maxVowels(String s, int k) {
        int left = 0, max = 0, current = 0;

        for (int right = 0; right < s.length(); right++) {

            if (isVowel(s.charAt(right))) {
                current++;
            }

            while (right - left > k - 1) {
                if (isVowel(s.charAt(left))) {
                    current--;
                }
                left++;
            }

            if (right - left == k - 1)
                max = Math.max(max, current);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || 
                c ==  'e' || 
                c ==  'i' || 
                c ==  'o' || 
                c ==  'u';
    }
}