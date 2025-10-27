class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length <= 2) return nums.length;

        int i = 2;  // start from index 2 because first two are always allowed
        for (int j = 2; j < nums.length; j++) {
            // compare current element with element 2 places before
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; 
    }
}