class Solution {
    public boolean isTrionic(int[] nums) {
        boolean c1 = false; // increasing
        boolean c2 = false; // decreasing
        boolean c3 = false; // increasing again
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            if (!c1) {
                if (curr > prev) {
                    c1 = true; 
                } else {
                    return false;
                }
            }
            else if (c1 && !c2) {
                if (curr > prev) {
                    continue;  
                } else if (curr < prev) {
                    c2 = true; 
                } else {
                    return false; 
                }
            }
            else if (c1 && c2 && !c3) {
                if (curr < prev) {
                    continue; 
                } else if (curr == prev) {
                    return false; 
                } else {
                    c3 = true; 
                }
            }
            else if (c1 && c2 && c3) {
                if (curr <= prev) {
                    return false; 
                }
            }
        }
        return c1 && c2 && c3;
    }
}