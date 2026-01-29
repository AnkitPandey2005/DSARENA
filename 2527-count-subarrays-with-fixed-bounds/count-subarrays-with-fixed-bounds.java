class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0;
        int minkpos=-1;
        int maxkpos=-1;
        int culpritidx=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK){
                culpritidx=i;
            }

            if(nums[i]==minK){
                minkpos=i;
            }

            if(nums[i]==maxK){
                maxkpos=i;
            }

            long smaller=Math.min(minkpos,maxkpos);
            long temp=smaller-culpritidx;
            ans+=(temp<=0)?0:temp;
        }
        return ans;
    }
}