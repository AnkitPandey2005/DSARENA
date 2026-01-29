class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }

        while(q.size()>1){
            for(int cnt=1;cnt<=k-1;cnt++){
                q.add(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }
}