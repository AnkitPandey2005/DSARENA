class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> numList=new ArrayList<>();
        for(int n:nums){
            numList.add(n);
        }
        getPerms(numList,0,ans);
        return ans;
    }
    public static void getPerms(List<Integer> nums,int idx,List<List<Integer>> ans){
        if(idx==nums.size()){
            ans.add(new ArrayList<>(nums));
        }
        for(int i=idx;i<nums.size();i++){
            Collections.swap(nums,idx,i);
            getPerms(nums,idx+1,ans);
            Collections.swap(nums,idx,i);
        }
    }
}