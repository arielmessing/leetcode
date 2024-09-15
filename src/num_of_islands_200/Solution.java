package num_of_islands_200;

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;

                    markIsland(grid, i, j);
                }
            }
        }

        return islands;
    }

    private void markIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || 
            j < 0 || j >= grid[i].length || 
            grid[i][j] == '0') 
            return;

        grid[i][j] = '0';

        markIsland(grid, i-1, j);
        markIsland(grid, i, j+1);
        markIsland(grid, i+1, j);
        markIsland(grid, i, j-1);
    }
}