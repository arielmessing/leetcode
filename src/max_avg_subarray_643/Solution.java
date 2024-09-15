package max_avg_subarray_643;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int left = 0, 
            count = 0;
        
        double max = Double.NEGATIVE_INFINITY,  // 'ans'
            avg = 0;

        for (int right = 0; right < nums.length; right++) {

            // do logic here to add arr[right] to curr
            double sum = avg * count + nums[right];
            count++;
            avg = sum / count;

            // WINDOW_CONDITION_BROKEN
            while (count > k) {

                // remove arr[left] from curr
                sum = avg * count - nums[left];
                count--;
                avg = sum / count;

                left++;
            }

            // update ans
            if (count == k) {
                max = Math.max(max, avg);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[] {-1}, 1));
        System.out.println(new Solution().findMaxAverage(new int[] {4,0,4,3,3}, 5));
    }
}