class Solution {
     private int[][] dp; 
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
         dp = new int[n][n];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1; // Initialize with -1 meaning not computed
            }
        }
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int player1 = solve(0, n - 1, nums);
        int player2 = totalSum - player1;

        return player1 >= player2;
    }

    private int solve(int i, int j, int[] nums) {
        if (i > j) {  //(no numbers left to choose).
            return 0;
        }
        if (i == j) {  // (only one number left).
            return nums[i];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take_i = nums[i] + Math.min(solve(i + 2, j, nums), solve(i + 1, j - 1, nums));
        int take_j = nums[j] + Math.min(solve(i + 1, j - 1, nums), solve(i, j - 2, nums));

        dp[i][j] = Math.max(take_i, take_j);
        return dp[i][j];
    }
}
