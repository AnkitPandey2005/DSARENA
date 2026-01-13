class Solution {
    public int largestPrime(int n) {
        int lat = n;  
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        int maxSum = 0;
        long prefixSum = 0;
        for (int i = 0; i < primes.size(); i++) {
            prefixSum += primes.get(i);
            if (prefixSum > n) break;
            if (isPrime[(int)prefixSum]) {
                maxSum = (int)prefixSum;
            }
        }
        return maxSum; 
    }
}