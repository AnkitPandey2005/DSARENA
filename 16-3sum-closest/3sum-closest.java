class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with first triplet sum

        for (int k = 0; k < n - 2; k++) {
            int i = k + 1, j = n - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (sum == target) {
                    return sum; // Perfect match found
                }

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return closestSum;
    }
}
