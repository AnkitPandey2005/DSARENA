class Solution {
    public int jump(int[] nums) {
        int N=nums.length;
        if(N==1)
        return 0;
        int farthest=0;
        int currend=0;
        int jump=0;
        for(int i=0;i<N;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(currend==i){
                currend=farthest;
                jump++;
            }
            if(currend>=N-1){
                return jump;
            }
        }
        return -1;
    }
}