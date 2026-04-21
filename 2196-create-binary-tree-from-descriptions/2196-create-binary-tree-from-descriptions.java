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
    Map<Integer , int[]> map;
    public TreeNode createBinaryTree(int[][] descriptions) {
        map = new HashMap<>();
        for(int[] d : descriptions){
            int par = d[0] , child = d[1] ;
            if(!map.containsKey(par)) map.put( par , new int[]{-1 , -1 , -1});
            if(d[2] == 1)  map.get(par)[0] = child;
            else map.get(par)[1] = child;
        }
        for(int[] d : descriptions) if(map.containsKey(d[1])) map.get(d[1])[2] = 1;
        int root = -1;
        for(int key : map.keySet()) if(map.get(key)[2] == -1) root = key;
        return genTree(root);
    }
    private TreeNode genTree(int key){
        TreeNode newNode = new TreeNode(key);
        if(map.containsKey(key) && map.get(key)[0] != -1) newNode.left = genTree(map.get(key)[0]);
        if(map.containsKey(key) && map.get(key)[1] != -1) newNode.right = genTree(map.get(key)[1]);
        return newNode;
    }
}