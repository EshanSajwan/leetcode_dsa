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
    public boolean isEvenOddTree(TreeNode root) {
        // even lvl pe all odds and st-Inc hone chiye , odd pe ulta
        boolean even = true;
        Queue<TreeNode> q = new LinkedList<>();
        int lvl = 0;
        q.offer(root);
        for(; !q.isEmpty() ;){
            // st-Inc matlab True
            int size = q.size();
            boolean stInc = true;
            int mod = 1 , last = 0;
            if(lvl % 2 == 1) {
                mod = 0;
                stInc = false;
                last = 1_000_001;
            }
            for(; size-- > 0 ;){
                TreeNode curr = q.poll();
                if(curr.val % 2 != mod) return false;
                if((stInc && curr.val <= last) || (!stInc && curr.val >= last) )
                    return false;
                last = curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            lvl++;
        }
        return true;
    }
}