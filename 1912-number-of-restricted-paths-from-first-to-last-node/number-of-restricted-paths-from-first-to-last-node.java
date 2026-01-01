class Pair{
    int vertex,weight;
    Pair(int v,int w){
        this.vertex=v;
        this.weight=w;
    }
}
class Solution {
    int mod=(int)1e9+7;
    List<List<Pair>> graph;
    int[] dist;
    int[] dp;

    public int countRestrictedPaths(int n, int[][] edges) {
        graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            graph.get(u).add(new Pair(v,w));
            graph.get(v).add(new Pair(u,w));
        }

        dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(n,dist);

        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(1,n);
    }

    void dijkstra(int start,int[] dist){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        dist[start]=0;
        pq.offer(new Pair(start,0));

        boolean[] vis=new boolean[dist.length];

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.vertex;
            int total=curr.weight;

            if(vis[u]) continue;
            vis[u]=true;

            for(Pair neighbours:graph.get(u)){
                int v=neighbours.vertex;
                int w=neighbours.weight;

                if(total+w<dist[v]){
                    dist[v]=total+w;
                    pq.offer(new Pair(v,dist[v]));
                }
            }
        }
    }
        int dfs(int u, int dest) {
        if (u == dest) return 1;
        if (dp[u] != -1) return dp[u];

        int ways = 0;

        for (Pair neighbour : graph.get(u)) {
            int v = neighbour.vertex;

            if (dist[u] > dist[v]) {
                ways = (ways + dfs(v, dest)) % mod;
            }
        }

        return dp[u] = ways;
    }
}