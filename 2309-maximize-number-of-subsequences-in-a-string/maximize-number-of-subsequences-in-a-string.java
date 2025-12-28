class Solution {
    public long maximumSubsequenceCount(String s, String p) {
        long ans=0,max=0;
        int cnt=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == p.charAt(1)) ans+=cnt;
            if(s.charAt(i) == p.charAt(0)) cnt++;
        } 

        max=Math.max(max,ans);
        ans=0;cnt=1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) == p.charAt(0)) ans+=cnt;
            if(s.charAt(i) == p.charAt(1)) cnt++;
        }
         max = Math.max(max, ans);
        return max;
    }
}