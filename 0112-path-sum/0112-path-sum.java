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
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return R(root , targetSum);
    }
    boolean R(TreeNode root , int T){
        if(root == null) return false;
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == T) return true;
            sum -= root.val;
            return false;
        }
        if(R(root.left , T)) return true;
        else if(R(root.right , T)) return true;
        else {
            sum-= root.val;
            return false;
        }
    }
}