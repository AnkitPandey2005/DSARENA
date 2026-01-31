class Solution {
    public int mySqrt(int x) {
       long ans=1;
       if(x==0) return 0;
       for(long i=1;i<=x;i++){
          if(i*i<=x){
            ans=i;
          }
          else{
            break;
          }
       }
       return (int)ans;
    }
}