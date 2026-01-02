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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Set<Integer> set = new HashSet<>();
        int max = -1;
        for(int i : nums) max = Math.max(i , max);
        int[] present = new int[max+1];
        for(int i : nums) present[i] = 1;
        ListNode dummy = new ListNode(0 , head);
        ListNode temp = dummy;
        while(temp.next != null){
            if(temp.next.val < max+1 && present[temp.next.val] == 1){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return dummy.next;
    }
}