package two_close_strings_1657;

import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] chars1 = countChars(word1);
        int[] chars2 = countChars(word2);

        return charsCountEquals(chars1, chars2);
    }

    private int[] countChars(String word) {
        int[] chars = new int[26];
        for (int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'a']++;
        }
        return chars;
    }

    private boolean charsCountEquals(int[] chars1, int[] chars2) {
       for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == 0 && chars2[i] != 0 || 
                chars1[i] != 0 && chars2[i] == 0) return false;
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) return false;
        }

        return true;
    }
}