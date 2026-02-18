class Solution {
    public boolean hasAlternatingBits(int n) {
        int c=n&1; //last digit of binary
        while(n>0){
            n=n>>1;
            int a=n&1;
            if(c==a){
                return false;
            }
            c=a;
        }
        return true;
    }
}