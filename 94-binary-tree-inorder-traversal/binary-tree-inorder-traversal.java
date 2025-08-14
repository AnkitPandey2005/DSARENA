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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Inorderhelper(root,ans);
        return ans;
    }
    public static void  Inorderhelper(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        Inorderhelper(root.left,ans);
         ans.add(root.val);
        Inorderhelper(root.right,ans);
    }
}