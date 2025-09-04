class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return CoinChange(amount, coins, 0, dp);
    }
    public static int CoinChange(int amount, int[] coins, int i, int[][] dp){
        if(amount == 0){
            return 1;
        }
        if(i == coins.length){
            return 0;
        }
        if(dp[amount][i] != -1){
            return dp[amount][i];
        }
        
        int inc = 0;
        int exc = 0;

        if(amount>=coins[i]){
            inc = CoinChange(amount - coins[i],coins, i, dp);
        }
        exc = CoinChange(amount, coins, i+1, dp);
        return dp[amount][i] = inc + exc;
    }
}