/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);

        int max = Integer.MIN_VALUE;
        int c = 0;     // level counter
        int ans = 0;   // answer level

        while (!pq.isEmpty()) {
            int n = pq.size();
            int s = 0;
            c++;

            while (n-- > 0) {
                TreeNode temp = pq.remove();
                s += temp.val;

                if (temp.left != null) pq.add(temp.left);
                if (temp.right != null) pq.add(temp.right);
            }

            if (s > max) {
                max = s;
                ans = c;
            }
        }

        return ans;
    }
}
