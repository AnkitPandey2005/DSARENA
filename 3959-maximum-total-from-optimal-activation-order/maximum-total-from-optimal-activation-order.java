class Solution {
    public long maxTotal(int[] value, int[] limit) {
        
        int n = value.length;

        int[][] arr = new int[n][2];
        int global =0;

        for(int i=0;i<n;i++){

            arr[i][0] = limit[i];
            arr[i][1] = value[i];
        }

        Arrays.sort( arr, (a,b) -> (a[0]==b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        long res=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a, b));

        for(int i=0;i<n;i++){

            int lim = arr[i][0];
            int v = arr[i][1];

            int s = pq.size();
            if(s < lim && lim>global){
                pq.add(lim);
                res+=(long)v;

                int x = pq.size();
                global = Math.max(global, x);

                while(!pq.isEmpty() && pq.peek() <= x ){
                    pq.poll();
                }
            } 
        }
        return res;
    }
}