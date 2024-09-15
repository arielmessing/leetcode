package text_justification_68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        var result = new ArrayList<String>();

        int lineStart = 0;

        while (lineStart < words.length) {
            int lineEnd = lineStart + 1;
            int lineLength = words[lineStart].length();

            while (lineEnd < words.length && (lineLength + words[lineEnd].length() + (lineEnd - lineStart - 1) < maxWidth)) {
                lineLength += words[lineEnd].length();
                lineEnd++;
            }

            int diff = maxWidth - lineLength;
            if (lineEnd - lineStart == 1 || lineEnd >= words.length) {
                result.add(justifyLeft(words, diff, lineStart, lineEnd));

            } else {
                result.add(justifyCentre(words, diff, lineStart, lineEnd));
            }

            lineStart = lineEnd;
        }

        return result;
    }

    private String justifyLeft(String[] words, int diff, int i, int j) {

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append(' ').append(words[k]);
        }

        sb.append(" ".repeat(diff - (j - i - 1)));

        return sb.toString();
    }

    private String justifyCentre(String[] words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;

        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            sb.append(" ".repeat(spaces + (extraSpaces-- > 0 ? 1 : 0))).append(words[k]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));

    }
}