class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        // Number of points
        int n = points.length;

        // Sort points by x, then by y if necessary
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int ans = 0;
        int i = 0;

        // Main loop to cover all points with rectangles
        while (i < n) {
            int start = points[i][0];
            int j = i + 1;

            // Find the farthest point within the rectangle's width
            while (j < n && points[j][0] <= start + w) {
                j++;
            }

            ans++;
            i = j;
        }
        return ans;
    }
}
