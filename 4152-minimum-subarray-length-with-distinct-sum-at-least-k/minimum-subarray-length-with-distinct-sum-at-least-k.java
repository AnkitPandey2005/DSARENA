class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        int x = n;  

        int minlen = Integer.MAX_VALUE;
        int left = 0;
        long sum = 0;
        Set<Integer> seen = new HashSet<>(); 
        Map<Integer, Integer> cnt = new HashMap<>(); 

        for (int r = 0; r < n; r++) {
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            if (cnt.get(nums[r]) == 1) {
                seen.add(nums[r]);
                sum += nums[r];
            }

            while (sum >= k && left <= r) {
                minlen = Math.min(minlen, r - left + 1); 

                cnt.put(nums[left], cnt.get(nums[left]) - 1);
                if (cnt.get(nums[left]) == 0) {
                    seen.remove(nums[left]);
                    sum -= nums[left];
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? -1 : minlen; 
    }
}