class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursionRight(root, 0, res);
        return res;
    }

    public void recursionRight(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        // Agar current level pehli baar visit ho raha hai
        if (res.size() == level) {
            res.add(root.val);
        }
        
        // Pehle RIGHT subtree visit karo (priority right ko dete hai)
        recursionRight(root.right, level + 1, res);
        
        // Phir LEFT subtree visit karo
        recursionRight(root.left, level + 1, res);
    }
}