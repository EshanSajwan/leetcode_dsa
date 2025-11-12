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
    public ListNode mergeNodes(ListNode head) {
        ListNode ptr = head; int sum = 0 ;
        while(ptr != null){
            if(ptr.val == 0){
                ListNode current = ptr;
                sum = 0;
                ptr = ptr.next;
                while(ptr != null && ptr.val != 0){
                    sum += ptr.val;
                    ptr = ptr.next;
                }
                current.val = sum;
                current.next = ptr;
            }
        }
        ptr = head;
        while(ptr.next.val != 0){    ptr = ptr.next;        }
        ptr.next = null;
        return head;
    }
}