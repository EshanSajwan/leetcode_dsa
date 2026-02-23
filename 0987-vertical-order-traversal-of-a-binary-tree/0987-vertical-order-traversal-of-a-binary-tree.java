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
    TreeMap<Integer ,TreeMap<Integer , ArrayList<Integer>>> map ;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        map = new TreeMap<>();
        dfs(root , 0 , 0);
        for(TreeMap<Integer , ArrayList<Integer>> tMap : map.values()){

            ArrayList<Integer> al = new ArrayList<>();
            for(ArrayList<Integer> currArr : tMap.values()){
                Collections.sort(currArr);
                for(int i : currArr) al.add(i);
            }
            ans.add(al);
        }
        return ans;
    }
    private void dfs(TreeNode root , int i , int j){
        if(root == null) return;
        if(!map.containsKey(i)) map.put(i , new TreeMap<>());
        if(!map.get(i).containsKey(j)) map.get(i).put(j , new ArrayList<Integer>());
        map.get(i).get(j).add(root.val);
        dfs(root.left  , i -1 , j+1);
        dfs(root.right , i + 1 , j+1);
    }
}