class Solution {
    public long maxStrength(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int x : nums) {
            if (x > 0) pos.add(x);
            else if (x < 0) neg.add(x);
        }
        neg.sort((a, b) -> Math.abs(a) - Math.abs(b));
        if (neg.size() % 2 != 0) {
            neg.remove(0);
        }
        if (pos.isEmpty() && neg.isEmpty()) {
            int max = nums[0];
            for (int x : nums) max = Math.max(max, x);
            return max;
        }
        long product = 1;
        for (int x : pos) product *= x;
        for (int x : neg) product *= x;
        return product;
    }
}