class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;

        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        int cnt=0;

       for (int i = 2; i< n; i++) {
            if (isPrime[i]) {
                cnt++;
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return cnt;
    }
}