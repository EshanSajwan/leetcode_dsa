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
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        F(root);
        return sb.toString();
    }
    void F(TreeNode root){

        sb.append(root.val);

        if(root.left!= null){
            sb.append('(');
            F(root.left);
            sb.append(')');
        }
        if(root.left == null && root.right != null){
            sb.append("()");
        }
        if(root.right != null){
            sb.append('(');
            F(root.right);
            sb.append(')');
        }

    }
}