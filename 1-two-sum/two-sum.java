class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int[] ans=new int[2];
        ans[0]=ans[1]=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            int moreneed=target-num;

            if(map.containsKey(moreneed)){
                ans[0]=map.get(moreneed);
                ans[1]=i;
            }
            map.put(arr[i],i);
        }
        return ans;
    }
}