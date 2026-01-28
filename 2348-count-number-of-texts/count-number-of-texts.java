class Solution {
    Long[][] mem = null;
    public int countTexts(String p) {
        mem = new Long[p.length()+1][10];
        Stack<int[]> arr = new Stack();
        for(int i=0; i<p.length(); i++) {
            if (arr.size() == 0 || arr.peek()[0] != (p.charAt(i)-'0')) {
                arr.push(new int[]{p.charAt(i)-'0', 1});
            } else {
                arr.peek()[1]++;
            }
        }
        ArrayList<int[]> list = new ArrayList(arr);
        long prod = 1;
        for(int[] x: list) {
            prod *= dp(x[1], x[0])%1000000007;
            prod = prod % 1000000007;
        }
        return (int)(prod%1000000007);
    }  
    long dp(int c, int l) {
        int[] let = new int[]{0,0,3,3,3,3,3,4,3,4};
        if (c <= 0) return 1;
        if (mem[c][l] != null) return mem[c][l];
        long ans = 0;
        for(int i=1; i<=let[l]; i++) {
            if (c >=i) ans += dp(c-i, l)%1000000007;
            ans = ans%1000000007;
        }
        mem[c][l] = ans;
        return ans;
    }
    
}