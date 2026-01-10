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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findSubTree(root , subRoot);
    }
    boolean findSubTree(TreeNode node , TreeNode target){
        if(node == null) return false;
        if(node.val == target.val) {
            if(check(node , target)) return true;
        }
        return findSubTree(node.left , target) || findSubTree(node.right , target);
    }
    boolean check(TreeNode node1 , TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null || node1.val != node2.val) return false;
        
        return check(node1.left , node2.left) && check(node1.right , node2.right);
    }
}