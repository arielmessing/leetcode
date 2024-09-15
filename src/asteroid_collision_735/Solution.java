package asteroid_collision_735;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {

            boolean collision = true;

            while (collision) {
                if (stack.isEmpty()) {
                    stack.push(asteroid);

                    collision = false;

                } else {                
                    int top = stack.peek();

                    if (collidingDirections(top, asteroid)) {
 
                        if (Math.abs(top) > Math.abs(asteroid)) {
                            collision = false;

                        } else if (Math.abs(top) < Math.abs(asteroid)) {
                            stack.pop();
                        
                        } else {
                            stack.pop();
                            collision = false;
                        }

                    } else {
                        stack.push(asteroid);

                        collision = false;
                    }
                }
            }
        }

        return flush(stack);    
    }

    private boolean collidingDirections(int left, int right) {
        return left > 0 && right < 0;
    }

    private int[] flush(Deque<Integer> stack) {
        int[] results = new int[stack.size()];
        int i = 0;
        while (! stack.isEmpty()) {
            results[i++] = stack.removeLast();
        }

        return results;
    }
}