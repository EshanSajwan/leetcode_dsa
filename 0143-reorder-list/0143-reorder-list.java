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
    public void reorderList(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            al.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        int i = 0 , j = al.size()-1;
        while(i <= j){
            temp.val = al.get(i++);
            if(temp.next == null) break;
            temp = temp.next;
            temp.val = al.get(j--);
            if(temp.next == null) break;
            temp = temp.next;            
        }
    }
}