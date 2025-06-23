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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dum = new ListNode(-200);
        ListNode curr = head, list = dum;
        while(curr != null) {
            ListNode dup = curr; boolean flag = true;
            while(dup.next != null && dup.val == dup.next.val) {
                dup = dup.next;
                flag = false; 
            }
            curr = dup;
            if(flag) {
                list.next = curr;
                list = list.next;
            }
            curr = curr.next;
        }
        list.next = null;
        return dum.next;
    }
}