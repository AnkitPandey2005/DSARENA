class Solution {
    public int totalFruit(int[] fruits) {
        int maxlen = 0;
        int lastFruit = -1, secondLastFruit = -1;
        int currCount = 0, lastFruitStreak = 0;

        for (int fruit : fruits) {
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currCount++;
            } else {
               
                currCount = lastFruitStreak + 1;
            }

            
            if (fruit == lastFruit) {
                lastFruitStreak++;
            } else {
                lastFruitStreak = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            maxlen = Math.max(maxlen, currCount);
        }

        return maxlen;
    }
}