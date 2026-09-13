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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> al = new ArrayList<>();
        preOrder(root , al); 
        List<List<Integer>> list = new ArrayList<>();
        for(int q : queries){
            int l = 0 , r = al.size();
            while(l < r){
                int mid = l + ( r - l ) / 2;
                if(al.get(mid) == q) r = l = mid;
                else if( al.get(mid) > q) r = mid - 1;
                else l = mid + 1;
            }
            List<Integer> li = new ArrayList<>();
            if(l == al.size()) l--;
            if(al.get(l) == q) {
                li.add(q);
                li.add(q);
            }
            else if(al.get(l) > q){
                if(l == 0) li.add(-1);
                else li.add( al.get(l - 1) );
                li.add( al.get(l) );
            }
            else{
                li.add(al.get(l));
                if(l == al.size() - 1) li.add(-1);
                else li.add( al.get(l + 1));
            }
            list.add(li);
        }
        return list;
    }
    private void preOrder(TreeNode root , List<Integer> al){
        if(root == null) return;
        preOrder(root.left , al);
        al.add(root.val);
        preOrder(root.right , al);
    }
}