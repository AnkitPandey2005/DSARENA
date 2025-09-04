class Solution {
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: when one string is empty
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // no operation needed
                } else {
                    int delete = dp[i - 1][j];     // delete operation
                    int replace = dp[i - 1][j - 1]; // replace operation
                    int insert = dp[i][j - 1];    // insert operation
                    dp[i][j] = Math.min(delete, Math.min(replace, insert)) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
