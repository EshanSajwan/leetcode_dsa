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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n % 2 == 0) return list;
        if(n == 1){
            TreeNode root = new TreeNode(0);
            list.add(root);
            return list;
        }
        for(int i = 1 ; i < n ; i += 2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}