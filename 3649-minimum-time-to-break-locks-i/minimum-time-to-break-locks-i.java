class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int n=strength.size();
        int[] dp=new int[1<<n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int m=0;m<(1<<n);m++){
            int t=dp[m];
            int f=1+k*Integer.bitCount(m);

            for(int i=0;i<n;i++){
                if((m & (1 <<i))==0){
                    int nm=m |(1<<i);
                    int reqt=(strength.get(i)+f-1)/f;
                    dp[nm]=Math.min(dp[nm],t+reqt);
                }
            }
        }
        return dp[(1<<n)-1];
    }
}