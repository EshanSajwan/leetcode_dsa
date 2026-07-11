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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null || root1.val != root2.val) return false;
        // flip both child and check OR don't flip and check
        
        return (flipEquiv(root1.left , root2.left) && flipEquiv(root1.right , root2.right))
            || (flipEquiv(root1.left , root2.right) && flipEquiv(root1.right , root2.left));
    }
}

        // if(root1 == null && root2 == null) return true;
        // if(root1 == null || root2 == null) return false;
        // if(root1.val != root2.val) return false;
        // // flip both child and check OR don't flip and check
        // boolean flip = false , binaFlip = false;
        // // first bina flip kare check kar
        // // if(root1.left.val == root2.left.val && root1.right.val == root2.right.val){
        //     boolean binaFlip = flipEquiv(root1.left , root2.left) && flipEquiv(root1.right , root2.right);
        // // }
        // // TreeNode temp = root2.left;
        // // root2.left = root2.right;
        // // root2.right = temp;
        // // if(root1.left.val == root2.right.val && root1.right.val == root2.left.val){
        //     boolean flip = flipEquiv(root1.left , root2.right) && flipEquiv(root1.right , root2.left);
        // // }
        // return flip || binaFlip;