class Solution {
    public long kMirror(int k, int n) {
        int L = 1; // palindrome length
        long sum = 0L;

        while (n > 0) {
            int half = (L + 1) / 2;
            long min = (long)Math.pow(10, half - 1);
            long max = (long)Math.pow(10, half) - 1;

            for (long num = min; num <= max && n > 0; num++) {
                long num1;
                if (L % 2 == 0) {
                    StringBuilder sb1 = new StringBuilder(String.valueOf(num));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(num));
                    sb1.append(sb2.reverse());
                    num1 = Long.parseLong(sb1.toString());
                } else {
                    StringBuilder sb1 = new StringBuilder(String.valueOf(num));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(num));
                    sb1.append(sb2.reverse().substring(1));
                    num1 = Long.parseLong(sb1.toString());
                }

                if (isPal(baseK(num1, k))) {
                    sum += num1;
                    n--;
                }
            }
            L++;
        }
        return sum;
    }

    public String baseK(long n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n = n / k;
        }
        return sb.toString();
    }

    public boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
