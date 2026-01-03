class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int e[] : dislikes){
            int v1 = e[0];
            int v2 = e[1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        HashMap<Integer,Integer>visited = new HashMap<>(); // vtx:dis

        Queue<Pair>q = new LinkedList<>();
        
        for(int i=1;i<n;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new Pair(i,0));
        
            while(!q.isEmpty()){
                Pair rm = q.poll();

                if(visited.containsKey(rm.vtx)){
                    if(visited.get(rm.vtx)!=rm.dist){
                        return false;
                    }
                    continue;
                }
                visited.put(rm.vtx,rm.dist);

                for(int ngbr : map.get(rm.vtx)){
                    if(!visited.containsKey(ngbr)){
                        q.add(new Pair(ngbr, rm.dist+1));
                    }
                }
            }
        }
        return true;
    }

    class Pair{
        int vtx;
        int dist;
        public Pair(int vtx, int dist){
            this.vtx = vtx;
            this.dist = dist;
        }
    }
}