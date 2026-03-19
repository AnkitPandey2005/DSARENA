class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<=n;i++){
            int cnt=0;
            int num=nums[i];
            for(int j=0;j<n;j++){
                if(nums[j]==num){
                    cnt++;
                }
            }
            if(cnt>(n/2)){
                return num;
            }
        }
        return -1;
    }
}