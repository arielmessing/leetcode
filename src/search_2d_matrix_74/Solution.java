package search_2d_matrix_74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length,
            columns = matrix[0].length;

        int min = 0,
            max = rows * columns - 1;

        while (min <= max) {
            int mid = min + (max - min)/2;

            int midValue = matrix[mid / columns][mid % columns];
            
            if (target == midValue) {
                return true;
            
            } else if (target < midValue) {
                max = mid - 1;

            } else {
                min = mid + 1;
            }
        }

        return false;
    }
}