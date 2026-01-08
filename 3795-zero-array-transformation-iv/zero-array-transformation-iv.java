class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int i=0;
        int j=queries.length;

        int ans = -1;

        while(i<=j){
            int mid = (i+j)/2;
            if(isKValid(nums, queries, mid)){
                ans = mid;
                j = mid-1;
            } else {
                i = mid+1;
            }
        }

        if(ans==-1) return -1;

        return ans;
    }

    public boolean isKValid(int[] nums, int[][] queries, int k){

        int max = -1;

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<k;i++){
            for(int j=queries[i][0];j<=queries[i][1];j++){
                list.get(j).add(queries[i][2]);
            }
        }

        for(int i=0;i<nums.length;i++){
            int[][] dp = new int[nums[i]+1][list.get(i).size()+1];

            for(int j=0;j<dp.length;j++){
                Arrays.fill(dp[j], -1);
            }

            if(!combinationSum(nums[i], 0, list.get(i), dp)){
                return false;
            }
        }


        return true;
    }

    public boolean combinationSum(int target, int i, List<Integer> list, int[][] dp){
        if(target==0) return true;
        if(i>=list.size() || target<0) return false;

        if(dp[target][i]!=-1) return (dp[target][i]==1)?true:false ;

        boolean take = combinationSum(target-list.get(i), i+1, list, dp);
        boolean notTake = combinationSum(target, i+1, list, dp);

        boolean found = take | notTake;

        if(found){ 
            dp[target][i] = 1;
        } else {
            dp[target][i] = 2;
        }

        return found;
    }
}