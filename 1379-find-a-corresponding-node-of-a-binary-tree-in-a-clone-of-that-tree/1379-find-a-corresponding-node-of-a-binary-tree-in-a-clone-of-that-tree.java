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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return rec(cloned , target);        
    }
    private TreeNode rec(TreeNode root , TreeNode target){
        if(root == null) return null;
        if(root.val == target.val) return root;
        TreeNode left = rec(root.left , target);
        if(left != null && left.val == target.val) return left;
        TreeNode right = rec(root.right , target);
        if(right != null && right.val == target.val) return right;
        return null;
    }
}