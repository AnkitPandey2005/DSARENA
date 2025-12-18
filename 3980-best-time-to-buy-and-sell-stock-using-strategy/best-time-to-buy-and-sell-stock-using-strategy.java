class Solution {
    public long maxProfit(int[] p, int[] s, int k) {
        int n = p.length, h = k / 2, i = 0;
        long b = 0;
        while (i < n) {
            b += (long) s[i] * p[i];
            i++;
        }
        long[] pp = new long[n+1], pa = new long[n+1];
        i = 0;
        while (i < n) {
            pp[i+1] = pp[i] + p[i];
            pa[i+1] = pa[i] + (long) s[i] * p[i];
            i++;
        }
        long a = b;
        i = 0;
        while (i <= n - k) {
            long o = pa[i + k] - pa[i];
            long nw = pp[i + k] - pp[i + h];
            long d = nw - o;
            long c = b + d;
            if (c > a) a = c;
            i++;
        }
        return a;
    }
}