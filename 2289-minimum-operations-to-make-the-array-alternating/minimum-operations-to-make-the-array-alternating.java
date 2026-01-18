class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++)  
            if (i % 2 == 0)
                map1.merge(nums[i], 1, Integer::sum);
            else
                map2.merge(nums[i], 1, Integer::sum);
        int c11 = 0, c12 = 0, c21 = 0, c22 = 0, n1 = 0, n2 = 0;
        for (int key : map1.keySet()) {  
            int val = map1.get(key);
            if (val >= c11) {
                c12 = c11;
                c11 = val;
                n1 = key;
            } else if (val > c12) 
                c12 = val;
        }
        for (int key : map2.keySet()) {  
            int val = map2.get(key);
            if (val >= c21) {
                c22 = c21;
                c21 = val;
                n2 = key;
            } else if (val > c22) 
                c22 = val;
        }
        if (n1 != n2)
            return nums.length - c11 - c21;
        else
            return nums.length - Math.max(c11 + c22, c21 + c12);
    }
}