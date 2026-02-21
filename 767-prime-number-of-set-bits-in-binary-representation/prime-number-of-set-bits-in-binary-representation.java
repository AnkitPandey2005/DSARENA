class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for (int i = left; i <= right; i++) {
            String BinaryString = Integer.toBinaryString(i);

            int cnt = 0;
            for (int j = 0; j < BinaryString.length(); j++) {
                if (BinaryString.charAt(j) == '1') {
                    cnt++;
                }
            }

            int cnt1 = 0;
            for (int k = 1; k * k <= cnt; k++) {
                if (cnt % k == 0) {
                    cnt1++;
                    if ((cnt / k) != k) {
                        cnt1++;
                    }
                }
            }

            if (cnt1 == 2) {
                ans++;
            }
        }
        return ans;
    }
}