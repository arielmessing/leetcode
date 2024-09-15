package random_pick_w_weights_528;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private final double[] probabilities;
    private final Random rand;

    public Solution(int[] w) {
        this.probabilities = new double[w.length];
        this.rand = new Random();

        var sum = Arrays.stream(w).sum();

        for (int i = 0; i < w.length; i++)
            probabilities[i] =
                    (i == 0 ? 0 : probabilities[i-1]) + (double) w[i] / sum;
    }
    
    public int pickIndex() {
        double point = rand.nextDouble();

        int left = 0, right = this.probabilities.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (probabilities[mid] < point)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */