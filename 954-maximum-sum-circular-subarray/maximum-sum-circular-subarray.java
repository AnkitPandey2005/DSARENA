class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minsum=Integer.MAX_VALUE;
        int maxsum=Integer.MIN_VALUE;
        int s1=0,s2=0,totalsum=0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
            s1+=nums[i];
            s2+=nums[i];
             maxsum=Math.max(maxsum,s1);
              minsum=Math.min(minsum,s2);
            if(s1<0){
                s1=0;
            }
            if(s2>0){
                s2=0;
            }
           
        }
         if (maxsum < 0) return maxsum;
         
        return Math.max(maxsum,totalsum-minsum);
    }
}