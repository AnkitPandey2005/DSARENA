class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n]; // track visited cities
        int provinces = 0; // count of connected components

        // try starting DFS from every city
        for (int i = 0; i < n; i++) {

            // if city not visited → new province found
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                provinces++;  // one full component explored
            }
        }

        return provinces;
    }

    // DFS to visit all cities in same province
    public void dfs(int city, int[][] isConnected, boolean[] visited) {

        visited[city] = true; // mark current city visited

        // check all possible neighbors (matrix traversal)
        for (int j = 0; j < isConnected.length; j++) {

            // if connected AND not visited → go deeper
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }
}