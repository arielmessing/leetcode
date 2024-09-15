package reverse_only_letters_917;

import java.util.Stack;

class Solution {
    public String reverseOnlyLetters(String s) {
        return reverseOnlyLetters2Pointers(s);
    }

    private String reverseOnlyLetters2Pointers(String s) {
        int left = 0,
            right = s.length() - 1;
        
        char[] sArr = s.toCharArray();

        while (left < right) {
            while (! Character.isLetter(sArr[left]) && left < right) left++;
            while (! Character.isLetter(sArr[right]) && left < right) right--;

            swap(sArr, left, right);
            left++;
            right--;
        } 

        return new String(sArr);
    }

    private void swap(char[] sArr, int i, int j) {
        var temp = sArr[i];
        sArr[i] = sArr[j];
        sArr[j] = temp;
    }

    private String reverseOnlyLettersStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(Character.isLetter(c) ? stack.pop() : c);
        }

        return sb.toString();
    }
}