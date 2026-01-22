class Solution {
    public int minimumPairRemoval(int[] nums) {
         List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        int operations = 0;
        
        while (true) {
            if (isNonDecreasing(list)) {
                break;
            }
            
            int minSum = Integer.MAX_VALUE;
            int mergeIndex = -1;
            
            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    mergeIndex = i;
                }
            }
           
            int sum = list.get(mergeIndex) + list.get(mergeIndex + 1);
            list.remove(mergeIndex + 1);
            list.set(mergeIndex, sum);
            operations++;
        }
        
        return operations;
    }
    
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}