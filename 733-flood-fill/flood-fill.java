import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];

        // Edge case
        if (orgColor == color) return image;

        int n = image.length;
        int m = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        image[sr][sc] = color;

        int[][] directions = {
            {-1, 0}, // top
            {0, 1},  // right
            {0, -1}, // left
            {1, 0}   // bottom
        };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m 
                    && image[ni][nj] == orgColor) {

                    image[ni][nj] = color;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        return image;
    }
}