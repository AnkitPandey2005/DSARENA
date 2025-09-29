class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            int[] temp = a; a = b; b = temp;
        }
        int lb = 0, ub = a.length;
        int t = a.length + b.length;
        int hf = (t + 1) / 2;

        while (lb <= ub) {
            int a1 = lb + (ub - lb) / 2;
            int b1 = hf - a1;

            int aleft  = (a1 == 0) ? Integer.MIN_VALUE : a[a1 - 1];
            int aright = (a1 == a.length) ? Integer.MAX_VALUE : a[a1];
            int bleft  = (b1 == 0) ? Integer.MIN_VALUE : b[b1 - 1];
            int bright = (b1 == b.length) ? Integer.MAX_VALUE : b[b1];

            if (aleft <= bright && bleft <= aright) {
                if (t % 2 == 0) {
                    return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
                } else {
                    return Math.max(aleft, bleft);
                }
            } else if (aleft > bright) {
                ub = a1 - 1;
            } else {
                lb = a1 + 1;
            }
        }
        return 0.0; 
    }
}
