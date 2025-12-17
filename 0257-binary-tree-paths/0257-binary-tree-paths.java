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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();

        dfs(root , new ArrayList<Integer>());
        return list;
    }
    void dfs(TreeNode node , ArrayList<Integer> al){
        al.add(node.val);
        if(node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();
            for(int num : al){
                sb.append(num);
                sb.append("->");
            }
            sb.deleteCharAt(sb.length() -1);sb.deleteCharAt(sb.length() -1);
            list.add(sb.toString());
            return;
        }
    
        if(node.left != null) 
        {
            dfs(node.left , al);
            al.removeLast();
        }
        if(node.right != null) 
        {
            dfs(node.right , al);
            al.removeLast();
        }
    }
}