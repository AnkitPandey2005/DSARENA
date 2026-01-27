class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
    int[] bound = new int[n]; 
    
    // Left to right: prefix max
    bound[0] = arr[0];
    for(int i = 1; i < n; i++) {
        bound[i] = Math.max(bound[i-1], arr[i]);
    }
    
    // Right to left: take min with suffix max
    int suffixMax = arr[n-1];
    for(int i = n-2; i >= 0; i--) {
        suffixMax = Math.max(suffixMax, arr[i+1]);
        bound[i] = Math.min(bound[i], suffixMax);
    }
    
    int total = 0;
    for(int i = 0; i < n; i++) {
        total += bound[i] - arr[i];
    }
    return total;
    }
}