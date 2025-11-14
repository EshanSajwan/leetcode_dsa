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
    ArrayList<Integer> al = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        R(root );
        return sum;
    }
    void R(TreeNode root ){
        if(root == null) return ;
        al.add(root.val);
        if(root.left == null && root.right == null){
            int num = 0;
            for(int i : al){
               num = num * 10 + i;
            }
            sum += num;
            al.remove(al.size()-1);
            return;
        }
        R(root.left );
        R(root.right);
        al.remove(al.size() -1);
    }
}