class Solution {
    public int longestBalanced(int[] nums) {
         int[] arr = nums;
        int maxlength = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd  = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                if (arr[j] % 2 == 0) {
                    even.add(arr[j]);
                } else {
                    odd.add(arr[j]);
                }
                //Subarray is balanced
                if (even.size() == odd.size()) {
                    maxlength = Math.max(maxlength, j - i + 1);
                }
            }
        }
        return maxlength;
    }
}