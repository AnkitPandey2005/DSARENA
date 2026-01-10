class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                map.putIfAbsent(rains[i], new LinkedList<>());
                map.get(rains[i]).add(i);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> filled = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake > 0) {
                map.get(lake).poll();

                if (filled.contains(lake)) return new int[0];
                filled.add(lake);

                if (!map.get(lake).isEmpty()) {
                    int nextDay = map.get(lake).peek();
                    pq.offer(new int[]{nextDay, lake});
                }

                ans[i] = -1;

            } else {
                if (!pq.isEmpty()) {
                    int[] soonest = pq.poll();
                    int dryLake = soonest[1];
                    filled.remove(dryLake);
                    ans[i] = dryLake;
                } else {
                    ans[i] = 1; 
                }
            }
        }
        return ans;
    }
}