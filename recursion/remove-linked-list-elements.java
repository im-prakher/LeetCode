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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(-9);
        dum.next = head;
        ListNode prev = dum, cur = head;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
            } else
                prev = prev.next;
            cur = cur.next;
        }
        return dum.next;
    }
}