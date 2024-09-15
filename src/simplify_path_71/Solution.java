import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.equals("..") && ! deque.isEmpty()) {
                deque.removeLast();
            }

            if (! part.isEmpty() && ! part.equals(".") && ! part.equals("..")) {
                deque.addLast(part);
            }
        }

        //return deque.stream().collect(Collectors.joining("/", "/", ""));

        StringBuilder sb = new StringBuilder();
        for (String part : deque) {
            sb.append("/").append(part);
        }

        if (sb.isEmpty()) sb.append("/");

        return sb.toString();
    }
}