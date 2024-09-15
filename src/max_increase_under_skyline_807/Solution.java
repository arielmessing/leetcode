package max_increase_under_skyline_807;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxIncrease = 0;

        int[] maxByRow = new int[grid.length];
        int[] maxByColumn = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                maxByRow[i] = Math.max(maxByRow[i], grid[i][j]);
                maxByColumn[j] = Math.max(maxByColumn[j], grid[i][j]);
            }
        }

         for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                maxIncrease += (Math.min(maxByRow[i], maxByColumn[j]) - grid[i][j]);
            }
        }  

        return maxIncrease;  
    }
}