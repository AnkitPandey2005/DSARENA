class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // We will use:
        // matrix[i][0] → to mark row i
        // matrix[0][j] → to mark column j

        // Special variable to track first column separately
        int col0 = 1;

        // ================= STEP 1 =================
        // Traverse whole matrix and mark rows & columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {

                    // Mark this row
                    matrix[i][0] = 0;

                    // Mark this column
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        // If zero is in first column,
                        // we cannot use matrix[0][0], so use col0
                        col0 = 0;
                    }
                }
            }
        }

        // ================= STEP 2 =================
        // Update the matrix (except first row & first column)
        // using the marks we stored
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                // If current cell is not already zero
                if (matrix[i][j] != 0) {

                    // Check:
                    // if its row OR column is marked
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // ================= STEP 3 =================
        // Handle first row separately
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column separately using col0
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}