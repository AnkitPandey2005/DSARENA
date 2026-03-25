class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j, n, m);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {

        // base case
        if (i < 0 || j < 0 || i >= n || j >= m 
            || visited[i][j] 
            || grid[i][j] == '0') {
            return;
        }

        // mark visited
        visited[i][j] = true;

        // 4 directions
        dfs(grid, visited, i - 1, j, n, m); // top
        dfs(grid, visited, i, j + 1, n, m); // right
        dfs(grid, visited, i, j - 1, n, m); // left
        dfs(grid, visited, i + 1, j, n, m); // bottom
    }
}