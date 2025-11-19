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
  //1 2 4 5 8 6 3 7 
class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        T(l  , root);
        boolean first = false;
        int index1 = 0, index2 = 0;
        for(int i = 0 ; i < l.size() ;i++){
            if( i == 0){
                if (l.get(i) > l.get(i+1)){
                        index1 = i;
                        first = true;
                }
            } else if(i == l.size()-1){
                if(l.get(i-1) > l.get(i)) index2 = i;
            }
            else{
                if(l.get(i-1) > l.get(i) || l.get(i) > l.get(i+1)){
                    if(!first){
                        index1 = i;
                        first = true;
                    }else{
                        index2 = i;
                        // break;
                    }
                }
            }
        }
        set(root , l.get(index1) , l.get(index2));
    }
    
    void T(List<Integer> l , TreeNode root){
        if(root == null) return ;
        T(l , root.left );
        l.add(root.val);
        T(l , root.right);
    }
    void set(TreeNode root , int val1 , int val2){
        if(root == null) return ;
        set( root.left , val1 , val2);
        if(root.val == val1) root.val = val2;
        else if(root.val == val2) root.val = val1;
        set(root.right, val1 , val2);

    }
}