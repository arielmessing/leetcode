package third_max_number_414;

class Solution {
    public int thirdMax(int[] nums) {
        Integer[] max = new Integer[3];

        for (Integer num : nums) {

            if (! num.equals(max[0]) && 
                ! num.equals(max[1]) && 
                ! num.equals(max[2])) {

                if (max[0] == null || num > max[0]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = num;

                } else if (max[1] == null || num > max[1]) {
                    max[2] = max[1];
                    max[1] = num;
                    
                } else if (max[2] == null || num > max[2]) {
                    max[2] = num;
                }
            }
        }

        return (max[2] != null) ? max[2] : max[0];
    }
}