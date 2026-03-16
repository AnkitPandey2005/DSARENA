class Solution {
    public int maxScore(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=0;
        int msum=0;

        for(int i=0;i<k;i++){
            left+=nums[i];
        }

        msum=left;

        int Ridx=n-1;
        for(int i=k-1;i>=0;i--){
            left=left-nums[i];
            right=right+nums[Ridx];
            Ridx=Ridx-1;
            msum=Math.max(msum,left+right);
        }
        return msum;
    }
}