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
    int maxi = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        int left = dfs(root.left , root.val);
        int right = dfs(root.right , root.val);
        return Math.max(maxi , left + right);
    }
    private int dfs(TreeNode root , int par){
        if(root == null) return 0;
        int left = dfs(root.left , root.val);
        int right = dfs(root.right , root.val);
        maxi = Math.max(maxi , left + right );
        if(root.val == par){
            return Math.max(left , right) + 1;
        }
        else return 0;
    }
}