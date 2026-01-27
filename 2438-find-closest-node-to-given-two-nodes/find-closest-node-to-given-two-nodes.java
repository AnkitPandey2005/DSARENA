class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        
        bfs(node1, edges, dist1);
        bfs(node2, edges, dist2);
        
        int res = -1;
        int minMaxDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    res = i;
                }
            }
        }
        return res;
    }
    
    private void bfs(int start, int[] edges, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int next = edges[curr];
            if (next != -1 && dist[next] == Integer.MAX_VALUE) {
                dist[next] = dist[curr] + 1;
                queue.offer(next);
            }
        }
    }
}