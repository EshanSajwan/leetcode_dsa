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
class FindElements {
    boolean[] isNode;
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        isNode = new boolean[1_100_001];
        root.val = 0;
        dfs(root);
    }
    
    public boolean find(int target) {
        return isNode[target];
    }
    private void dfs(TreeNode curr){
        isNode[curr.val] = true;
        if(curr.left != null){
            curr.left.val = curr.val * 2 + 1;
            dfs(curr.left);
        }
        if(curr.right != null){
            curr.right.val = curr.val * 2 + 2;
            dfs(curr.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */