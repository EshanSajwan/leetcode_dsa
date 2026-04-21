/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for(int[] arr : mat) Arrays.fill(arr , -1);
        int top = 0 , l = 0 , r = n -1 , bottom = m - 1;
        ListNode temp = head;
        while(temp != null && l <= r && top <= bottom){
            for(int i = l ; i < r + 1 && temp != null ; i++) {
                mat[top][i] = temp.val;
                temp = temp.next;
            }
            top++;
            for(int i = top ; i < bottom + 1 && temp != null ; i++){
                mat[i][r] = temp.val;
                temp = temp.next;
            }
            r--;
            for(int i = r ; i > l - 1 && temp != null ; i--){
                mat[bottom][i] = temp.val;
                temp = temp.next;
            }
            bottom--;
            for(int i = bottom ; i > top - 1 && temp != null ; i--){
                mat[i][l] = temp.val;
                temp = temp.next;
            }
            l++;
        }
        return mat;
    }
}