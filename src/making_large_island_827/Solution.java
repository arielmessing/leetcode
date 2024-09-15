package making_large_island_827;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    static final int[][] DIRECTIONS =
            new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int maxIsland = 0;

        var sizeByIslandMark = new HashMap<Integer, Integer>();
        var islandMark = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    var islandSize = markIsland(grid, i, j, ++islandMark);

                    maxIsland = Math.max(maxIsland, islandSize);
                    sizeByIslandMark.put(islandMark, islandSize);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
//                    var newSize = 1 +
//                            getAdjacentIslands(grid, i, j).stream()
//                                .mapToInt(sizeByIslandMark::get)
//                                .sum();

                    var newSize = 1;
                    for (int adjacent : getAdjacentIslands(grid, i, j)) {
                        newSize += sizeByIslandMark.get(adjacent);
                    }

                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }

    private int markIsland(int[][] grid, int i, int j, int mark) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[i].length ||
                grid[i][j] != 1)
            return 0;

        grid[i][j] = mark;

        int islandSize =
            markIsland(grid, i-1, j, mark) +
            markIsland(grid, i, j+1, mark) +
            markIsland(grid, i+1, j, mark) +
            markIsland(grid, i, j-1, mark) +
                    1;

        return islandSize;
    }

    private Set<Integer> getAdjacentIslands(int[][] grid, int i, int j) {
        Set<Integer> adjacents = new HashSet<>();

        for (int[] direction : DIRECTIONS) {
            int x = i + direction[0],
                    y = j + direction[1];

            if (x >= 0 && x < grid.length &&
                    y >= 0 && y < grid[0].length &&
                    grid[x][y] != 0) {

                adjacents.add(grid[x][y]);
            }
        }

        return adjacents;
    }

    private Set<Integer> getAdjacentIslands1(int[][] grid, int i, int j) {
        return Arrays.stream(DIRECTIONS)
                .map(coordinates -> new int[] {i + coordinates[0], j + coordinates[1]})
                .filter(coordinates -> coordinates[0] >= 0 &&
                                coordinates[0] < grid.length &&
                                coordinates[1] >= 0 &&
                                coordinates[1] < grid[0].length &&
                                grid[coordinates[0]][coordinates[1]] != 0)
                .map(coordinates -> grid[coordinates[0]][coordinates[1]])
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestIsland(new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0}, 
                {0, 0, 0, 0, 0}}));

        System.out.println(new Solution().largestIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}}));
    }
}