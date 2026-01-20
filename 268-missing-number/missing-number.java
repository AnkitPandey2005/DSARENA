class Solution {
    public int missingNumber(int[] arr) {
        int N = arr.length;
        int hash[] = new int[N + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i < N; i++)
            hash[arr[i]]++;

        // Fix 1: Check from 0 to N (not 1 to N)
        // Fix 2: Range should be <= N to include N itself
        for (int i = 0; i <= N; i++) { 
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
