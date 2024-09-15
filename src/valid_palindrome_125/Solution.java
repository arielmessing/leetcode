package valid_palindrome_125;

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (left < right) {
            char leftChar = sArr[left];
            char rightChar = sArr[right];

            if (! Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (! Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
                    return false;

                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
        System.out.println(new Solution().isPalindrome(" "));
    }
}