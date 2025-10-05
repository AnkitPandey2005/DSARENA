class Solution {
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; //down up right left
    
    public int DFS(int[][] grid, int i, int j) {
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) {
            return 0; // Out of bounds or no gold
        }

        int originalGoldValue = grid[i][j];
        grid[i][j] = 0; // Mark visited

        int maxGold = 0;

        // Explore all four directions
        for(int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            maxGold = Math.max(maxGold, DFS(grid, new_i, new_j));
        }

        // Backtrack - restore original value
        grid[i][j] = originalGoldValue;
        return originalGoldValue + maxGold;
    }

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxGold = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, DFS(grid, i, j));
                }
            }
        }
        return maxGold;
    }
}
