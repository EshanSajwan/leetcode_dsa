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
    Map<String , List<TreeNode>> memo;
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        memo = new HashMap<>();
        return billu(1 , n);
    }
    private List<TreeNode> billu(int l , int r){
        String curr = l + "*" + r;
        if(memo.containsKey(curr)) return memo.get(curr);
        List<TreeNode> al = new ArrayList<>();
        if(l > r){
            al.add(null);
            return al;
        }
        for(int i = l ; i <= r ; i++){
            List<TreeNode> left = billu(l , i - 1);
            List<TreeNode> right = billu(i + 1 , r);
            for(TreeNode ll : left){
                for(TreeNode rr : right){
                    TreeNode node = new TreeNode(i);
                    node.left = ll;
                    node.right = rr;
                    al.add(node);
                }
            }
        }
        memo.put(curr , al);
        return al;
    }
}