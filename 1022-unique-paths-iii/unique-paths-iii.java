class Solution {
    int m, n;
    int emptyCells;
    int result = 0;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(int[][] grid, int currCount, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }
        if (grid[i][j] == 2) {
            if (currCount == emptyCells) {
                result++;
            }
            return;
        }
        
        int temp = grid[i][j];
        grid[i][j] = -1;  // mark visited
        for (int[] dir : directions) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid, currCount + 1, nextI, nextJ);
        }
        grid[i][j] = temp;  // unmark for other paths
    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        emptyCells = 0;
        result = 0;

        int startX = 0, startY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    emptyCells++;
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        emptyCells += 1; // Include start square
        dfs(grid, 0, startX, startY);
        return result;
    }
}
