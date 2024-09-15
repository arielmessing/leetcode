package word_search_79;

class Solution {

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows = board.length,
            columns = board[0].length;
        
        visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                
                if (word.charAt(0) == board[i][j] && exist(board, word, i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j) {
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;

        if (word.charAt(0) != board[i][j]) return false;

        if (visited[i][j]) return false;

        visited[i][j] = true;

        if (word.length() > 1) {
            word = word.substring(1);

            if (exist(board, word, i + 1, j) ||
                exist(board, word, i - 1, j) ||
                exist(board, word, i, j + 1) ||
                exist(board, word, i, j - 1))
                return true;

            visited[i][j] = false;
            return false;
        }

        return true;
    }
}