class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        int[] result=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        Arrays.sort(deck);
        for(int i=0;i<n;i++){
            int idx=q.poll();
            result[idx]=deck[i];

            if(!q.isEmpty()){ //pop kiya uske baad m joo element h usko queue k back m push kr do aur usko pop kr do aage se 
            q.offer(q.peek());
            q.poll();
          }
        }
        return result;
    }
}