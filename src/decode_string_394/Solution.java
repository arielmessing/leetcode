package decode_string_394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> counts = new Stack<>();
        Stack<String> decoded = new Stack<>();

        StringBuilder result = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);

            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(c)) {
                    count = 10 * count + (c - '0');
                    index++;
                    c = s.charAt(index);
                }
                counts.push(count);

            } else if (c == '[') {
                decoded.push(result.toString());
                result = new StringBuilder();
                index++;

            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(decoded.pop());

                int count = counts.pop();
                sb.append(result.toString().repeat(count));

                result = sb;

                index++;

            } else {
                result.append(c);
                index++;
            }
        }

        return result.toString();
    }
}