package array_product_except_self_238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int[] productPrefixes = new int[nums.length];
        int[] productSuffixes = new int[nums.length];

        productPrefixes[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productPrefixes[i] = nums[i - 1] * productPrefixes[i - 1];
        }

        productSuffixes[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            productSuffixes[i] = nums[i + 1] * productSuffixes[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = productPrefixes[i] * productSuffixes[i];
        }

        return answer;
    }

    public int[] productExceptSelfV2(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int productSuffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * productSuffix;
            productSuffix = productSuffix * nums[i];
        }

        return answer;
    }
}

//  1  2  3  4

//> 1  1  2  6
//  24 12 4  1 <

//  24 12 8  6
