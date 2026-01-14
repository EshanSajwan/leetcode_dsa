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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode secHalf = splitLL(head);
        ListNode left = sortList(head);
        ListNode right = sortList(secHalf);
        return merge(left, right);
    }
    static ListNode merge(ListNode left , ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode t1 = left , t2 = right , curr = dummy;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                curr.next = t1;
                t1 = t1.next;
                curr = curr.next;
            } else if(t1.val > t2.val){
                curr.next = t2;
                t2 = t2.next;
                curr = curr.next;
            } else {
                curr.next = t1;
                t1 = t1.next;
                curr.next.next = t2;
                curr = t2;
                t2 = t2.next;
            }
        }
        if(t1 != null)  curr.next = t1;
        if(t2 != null)  curr.next = t2;
        return dummy.next;
    }
    static ListNode splitLL(ListNode head){
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secHalf = slow.next;
        slow.next = null;
        return secHalf;
    }
}