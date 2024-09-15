package phone_num_letter_combinations_17;

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isBlank()) return List.of();

        Map<Character, List<String>> map = Map.of(
                '2', List.of("a", "b", "c"),
                '3', List.of("d", "e", "f"),
                '4', List.of("g", "h", "i"),
                '5', List.of("j", "k", "l"),
                '6', List.of("m", "n", "o"),
                '7', List.of("p", "q", "r", "s"),
                '8', List.of("t", "u", "v"),
                '9', List.of("w", "x", "y", "z"));

        List<String> results = new ArrayList<>();

        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(digits);

        int index = 0;
        while (! queue.isEmpty()) {
            int size = queue.size();

            var target = (index == digits.length() - 1) ? results : queue;

            for (int i = 0; i < size; i++) {
                String s = queue.removeFirst();

                char key = s.charAt(index);

                List<String> options = map.get(key);
                for (String option: options) {
                    target.add(s.substring(0, index) + option + s.substring(index+1)    );
                }
            }

            index++;
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}