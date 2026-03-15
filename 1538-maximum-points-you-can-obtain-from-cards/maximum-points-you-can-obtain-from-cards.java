class Solution {
    public int maxScore(int[] nums, int k) {
        int leftsum=0;
        int rightsum=0;
        int maxsum=0;
        int n=nums.length;

        for(int i=0;i<=k-1;i++){
            leftsum+=nums[i];
        }


        maxsum=leftsum;
        int Ridx=n-1;
        for(int i=k-1;i>=0;i--){
            leftsum=leftsum-nums[i];
            rightsum=rightsum+nums[Ridx];
            Ridx=Ridx-1;
            maxsum=Math.max(maxsum,leftsum+rightsum);
        }
        return maxsum;
    }
}