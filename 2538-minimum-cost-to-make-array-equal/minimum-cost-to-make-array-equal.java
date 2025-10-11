class Solution {
    public long minCost(int[] nums, int[] cost) {
        long answer = Long.MAX_VALUE;

        int left = Arrays.stream(nums).min().getAsInt(); //to find the minimum in the array
        int right = Arrays.stream(nums).max().getAsInt(); //to find the maximum in the array 

        while(left<=right){
            int mid=(left)+(right-left)/2;

            long cost1=findcost(nums,cost,mid);
            long cost2=findcost(nums,cost,mid+1);
            
            answer=Math.min(cost1,cost2);

            if(cost2>cost1){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return answer== Long.MAX_VALUE ? 0:answer;
    }
    public static long findcost(int[] nums,int[] cost,int target){
        long result=0;

        for(int i=0;i<nums.length;i++){

            result+=(long)Math.abs(nums[i]-target)*cost[i];
        }
        return result;
    }
}