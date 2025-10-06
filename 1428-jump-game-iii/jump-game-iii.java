import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (arr[curr] == 0) {
                return true;
            }

            int index = curr - arr[curr];

            if (index >= 0 && !visited.contains(index)) {
                visited.add(index);
                queue.offer(index);
            }

            index = curr + arr[curr];

            if (index < arr.length && !visited.contains(index)) {
                visited.add(index);
                queue.offer(index);
            }
        }
        return false;
    }
}
