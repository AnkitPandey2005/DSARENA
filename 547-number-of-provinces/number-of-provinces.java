import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Step 1: Convert matrix to adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        // Step 2: DFS to count provinces
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int curr, List<List<Integer>> adj, boolean[] visited) {
        visited[curr] = true;

        for (int nbr : adj.get(curr)) {
            if (!visited[nbr]) {
                dfs(nbr, adj, visited);
            }
        }
    }
}