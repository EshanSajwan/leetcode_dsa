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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return maxi;
    }
    private int find(TreeNode root){
        if(root == null) return 0;
        int left = find(root.left) , right = find(root.right);
        maxi = Math.max( maxi , Math.max( root.val , 
                                    Math.max( left + root.val + right , 
                                    Math.max(root.val + left , root.val + right))));
        return Math.max( root.val , Math.max( root.val + left , root.val + right));
    }
}