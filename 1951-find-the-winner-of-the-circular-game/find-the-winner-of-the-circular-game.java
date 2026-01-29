class Solution {
    public int findTheWinner(int n, int k) {
        int result=findWinner(n,k);
        return result+1;
    }
    public static int findWinner(int n,int k){
        if(n==1){
            return 0;
        }

        int idx=findWinner(n-1,k);
        idx=(idx+k)%n;
        return idx;
    }
}