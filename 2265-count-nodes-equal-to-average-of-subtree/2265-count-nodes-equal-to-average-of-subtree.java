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
    record pair( int sum , int num ){}
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        fxn( root );
        return count;
    }
    private pair fxn( TreeNode root ){
        if(root.left == null && root.right == null) {
            count++;
            return new pair(root.val , 1);
        }
        if(root.left == null){
            pair r = fxn(root.right);
            int x = ( root.val + r.sum ) / (1 + r.num);
            if(root.val == x) count++;
            return new pair( root.val + r.sum  , 1 + r.num);
        }
        if(root.right == null){
            pair l = fxn(root.left);
            int x = ( root.val + l.sum ) / (1 + l.num);
            if(root.val == x) count++;
            return new pair( root.val + l.sum  , 1 + l.num);
        }
        pair l = fxn(root.left) , r = fxn(root.right);
        int x = ( l.sum + root.val + r.sum ) / ( l.num + 1 + r.num );
        if(root.val == x) count++;
        return new pair( root.val + l.sum + r.sum  , 1 + l.num + r.num);
    }
}