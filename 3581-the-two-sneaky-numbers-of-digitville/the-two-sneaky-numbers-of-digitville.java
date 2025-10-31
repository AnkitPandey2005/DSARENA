class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(it.getValue()==2){
                ans.add(it.getKey());
            }
        }
       
       int[] result=new int[ans.size()];
       for(int i=0;i<ans.size();i++){
           result[i]=ans.get(i);
       }
       return result;
    }
}