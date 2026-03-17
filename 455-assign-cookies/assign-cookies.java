class Solution {
    public int findContentChildren(int[] greed, int[] size) {
        int n = greed.length;
        int m = size.length;

        Arrays.sort(greed);
        Arrays.sort(size);

        int l = 0; // pointer for cookies
        int r = 0; // pointer for children
        int count = 0;

        while (l < m && r < n) {
            if (size[l] >= greed[r]) {
                count++;   // child satisfied
                r++;       // move to next child
            }
            l++; // move to next cookie
        }

        return count;
    }
}