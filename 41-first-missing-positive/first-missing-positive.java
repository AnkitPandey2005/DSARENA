class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean hasOne = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) hasOne = true;
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }

        if (!hasOne) return 1;

       
        for (int i = 0; i < n; i++) {
            int x = Math.abs(arr[i]);
            if (x == n) {
                arr[0] = -Math.abs(arr[0]);  
            } else {
                arr[x] = -Math.abs(arr[x]);
            }
        }

        
        for (int i = 1; i < n; i++) {
            if (arr[i] > 0) return i;
        }

        if (arr[0] > 0) return n;
        return n + 1;
    }
}
