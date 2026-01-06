class Solution {
    public int tribonacci(int n) {
        int a=0;
        int b=1;
        int c=1;
        int d=1;
        for(int i=1;i<=n;i++){
            d=a+b+c;
            a=b;
            b=c;
            c=d;
        }
        return a;
    }
}