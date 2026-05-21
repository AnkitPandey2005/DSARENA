class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr1) {
            while(num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int ans = 0;

        for(int num : arr2) {
            int x = num;
            int len = String.valueOf(num).length();

            while(x > 0) {
                if(set.contains(x)) {
                    ans = Math.max(ans, len);
                    break;
                }

                x /= 10;
                len--;
            }
        }

        return ans;
    }
}