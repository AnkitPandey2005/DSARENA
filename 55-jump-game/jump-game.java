class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIndex) return false; //max you able to reach is maxindex how did you greater than maxindex

            maxIndex=Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }
}