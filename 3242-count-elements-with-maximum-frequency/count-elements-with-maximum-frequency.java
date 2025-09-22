class Solution {
    public int maxFrequencyElements(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>(); 
       for(int i:nums){
           if(map.containsKey(i)){
               map.put(i,map.get(i)+1);
           }else{
               map.put(i,1);
           }
       }

       int max=0;
       for(int i:map.values()){
            max=Math.max(max,i);
       }

       int cnt=0;
       for(int i:map.values()){
            if(i==max){
                cnt++;
            }
       }
       return max*cnt;
    }
}