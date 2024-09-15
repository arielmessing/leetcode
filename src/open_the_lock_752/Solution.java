package open_the_lock_752;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {

    static final String START_STATE = "0000";

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
    
        for (String deadend : deadends) {
            if (deadend.equals(START_STATE)) return -1;

            visited.add(deadend);
        }

        visited.add(START_STATE);

        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(START_STATE);

        int level = 0;
        while (! queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String state = queue.removeFirst();

                if (target.equals(state)) {
                    return level;
                }

                for (int j = 0; j < state.length(); j++) {
                    char digit = state.charAt(j);

                    String up = 
                        state.substring(0, j) + 
                        (digit == '9' ? 0 : digit - '0' + 1) + 
                        state.substring(j + 1);

                    if (! visited.contains(up)) {
                        queue.addLast(up);
                        visited.add(up);
                    }

                    String down = 
                        state.substring(0, j) + 
                        (digit == '0' ? 9 : digit - '0' - 1) + 
                        state.substring(j + 1);

                    if (! visited.contains(down)) {
                        queue.addLast(down);
                        visited.add(down);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}