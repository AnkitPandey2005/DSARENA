class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] t = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    // Last cell (destination)
                    t[i][j] = dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
                } else {
                    int down = (i + 1 >= m) ? (int)1e9 : t[i + 1][j];
                    int right = (j + 1 >= n) ? (int)1e9 : t[i][j + 1];

                    int result = Math.min(down, right) - dungeon[i][j];
                    t[i][j] = result > 0 ? result : 1;
                }
            }
        }
        return t[0][0]; // Minimum health required to reach (m-1, n-1) from (0,0)
    }
}
