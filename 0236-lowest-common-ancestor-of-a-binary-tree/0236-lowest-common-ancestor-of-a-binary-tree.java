/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root , p , q);
        return lca;
    }
    boolean dfs(TreeNode root , TreeNode p , TreeNode q){
        if(root == null) return false;
        boolean left = false , right = false;
        left = dfs(root.left , p , q);
        right = dfs(root.right , p , q);
        if(lca == null){ //only check if lca is not found yet;
            if(left && right)
                 lca = root;
            else if((left || right) && (root == p || root == q))
                 lca = root;
        }
        return left || right || root == p || root == q ;
    }
}