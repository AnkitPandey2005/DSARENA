class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);
        }

        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(it.getValue()==edges.length){
                return it.getKey(); //star graph
            }
        }
        return -1;
    }
}