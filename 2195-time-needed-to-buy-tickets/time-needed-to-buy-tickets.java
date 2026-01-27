class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n=tickets.length;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){ //issme phele saare index queue m daal de
            q.add(i);
        }
        int time=0;
        while(tickets[k]!=0){  //jb tk req wala indx 0 naa tb tk krte rho
            int z=q.poll();  //start se element nekal
            tickets[z]=tickets[z]-1;  //usko aek ticket buy krne k baad subtract phir uske peeche queue m add kr dege
            if(tickets[z]!=0){
                q.add(z);
            }
            time++;
        }
        return time;
    }
}