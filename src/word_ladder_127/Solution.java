package word_ladder_127;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (! wordSet.contains(endWord)) return 0;

        int length = 1;
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.addLast(beginWord);
        visited.add(beginWord);

        while (! queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.removeFirst();

                if (word.equals(endWord)) 
                    return length;

                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String transformed = word.substring(0, j) + c + word.substring(j + 1);

                        if (wordSet.contains(transformed) && 
                            ! visited.contains(transformed)) {

                            queue.addLast(transformed);
                            visited.add(transformed);
                        }
                    }
                }
            }

            length++;
        }

        return 0;
    }
}