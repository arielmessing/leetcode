package longest_substring_no_repeat_3;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int maxLength = 0;
   
        Set<Character> set = new HashSet<>();
        char[] sArr = s.toCharArray();

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            
            if (! set.contains(sArr[end])) {
                set.add(sArr[end]);
                maxLength = Math.max(maxLength, end - start + 1);

            } else {
                while (set.contains(sArr[end])) {
                    set.remove(sArr[start]);
                    start++;
                }

                set.add(sArr[end]);
            }
        }

        return maxLength;
    }
}