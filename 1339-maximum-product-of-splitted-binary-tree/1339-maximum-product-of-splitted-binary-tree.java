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
    long totalSum = 0 , maxProd = 0;
    public int maxProduct(TreeNode root) {
        findAllSum(root);
        dfs(root);
        return (int)(maxProd % 1_000_000_007);
    }
    private long dfs(TreeNode root){
        if(root == null) return 0;
        long sum = dfs(root.left) + root.val + dfs(root.right);
        long res = (sum  * (totalSum - sum)) ;
        maxProd = Math.max( maxProd , res );
        return sum;
    }
    private void findAllSum(TreeNode root){
        if(root == null) return;
        totalSum += root.val;
        findAllSum(root.left);
        findAllSum(root.right);
    }
}