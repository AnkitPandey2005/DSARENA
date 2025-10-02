class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length) {
            // If the cookie satisfies the student's greed
            if (s[j] >= g[i]) {
                i++;
            }
            // Move to next cookie in both cases
            j++;
        }

        // Number of students satisfied is equal to studentIndex
        return i;
    }
}