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
    int pathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return pathSum;
    }
    int dfs(TreeNode node )
    {
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int curr = node.val;
        int leftSum = curr + left;
        int rightSum = curr + right;
        int bothSum = curr + left + right;
        pathSum = Math.max(pathSum , Math.max(curr , Math.max( bothSum , Math.max(leftSum , rightSum))));

        return Math.max(node.val , Math.max(leftSum , rightSum));
    }
}