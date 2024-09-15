package rotate_image_48;

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flipVertically(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                var temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void flipVertically(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0,
                right = matrix[i].length - 1;
            
            while (left <= right) {
                var temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}