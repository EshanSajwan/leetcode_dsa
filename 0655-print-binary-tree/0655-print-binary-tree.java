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
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        List<List<String>> list = new ArrayList<>();
        for(int i = 0 ; i < h ; i++) list.add(new ArrayList<>());
        int x = (int)Math.pow(2 , h) - 1;
        for(List<String> l : list){
            for(int i = 0 ; i < x ;i++) l.add(new String(""));
        }
        list.get(0).set((x -1)/2 , String.valueOf(root.val));
        dfs(1 , (x -1)/2 , h, root.left , list , false);dfs(1 , (x -1)/2, h, root.right , list , true);
        return list;
    }
    private void dfs(int i , int c, int h, TreeNode root , List<List<String>> list , boolean flag){
        if(root == null) return ;
        int y = (int)Math.pow(2 , h - i - 1);
        if(!flag) y = c - y;
        else y = c + y;
        if(!flag) list.get(i).set( y , String.valueOf(root.val));
        if(flag) list.get(i).set( y , String.valueOf(root.val));
        dfs(i + 1 , y , h, root.left , list , false);
        dfs(i + 1 , y , h, root.right , list , true);
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max( height(root.left) , height(root.right) );
    }
}