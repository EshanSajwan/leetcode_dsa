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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;
        int index = indexOf(preorder[1] , postorder);
        if(index + 2 > 1){
            int[] leftPre = Arrays.copyOfRange(preorder , 1 , index + 2 );
            int[] leftPost = Arrays.copyOfRange(postorder , 0 , index + 1 );
            root.left = constructFromPrePost(leftPre , leftPost); 
        }
        if(preorder.length > index + 2){
            int[] rightPre = Arrays.copyOfRange(preorder , index + 2, preorder.length );
            int[] rightPost = Arrays.copyOfRange(postorder , index + 1 , postorder.length - 1 );
            root.right = constructFromPrePost(rightPre , rightPost); 
        }
        return root;
    }
    private int indexOf(int num , int[] arr){
        for(int i = 0 ; i < arr.length ; i++) if(arr[i] == num) return i;
        return -1;
    }
}