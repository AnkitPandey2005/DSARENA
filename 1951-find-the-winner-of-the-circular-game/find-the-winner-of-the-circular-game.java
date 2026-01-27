class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }

        int c=0;
        while(q.size()>1){
            int val=q.poll();
            c++;
            if(c!=k){
                q.add(val);
            }
            else{
                c=0;
            }
        }
        return q.poll();
    }
}