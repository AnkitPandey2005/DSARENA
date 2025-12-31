class Solution {
    private int[] parent;
    private int[] rank;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];
        
        // Initialize parent and rank
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;  // Rank starts at 0
        }
        
        // Union all edges
        for (int[] edge : edges) {
            int n1 = find(edge[0]);
            int n2 = find(edge[1]);
            
            if (n1 != n2) {
                union(n1, n2);
            }
        }
        
        return find(source) == find(destination);
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}
