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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode curr = head; 
        ListNode dum = new ListNode(-1);
        dum.next = head;
        while(curr!=null) {
            curr = curr.next;
            n++;
        }
        curr = head;
        ListNode prev = dum;
        while(n-- >= k) {
            ListNode first = curr;
            ListNode end = curr;
            ListNode nex = curr.next;
            for(int i = k-1; i > 0; i--) {
                end = nex;
                nex = end.next;
                end.next = curr;
                curr = end;
                n--;
            }
            first.next = nex;
            prev.next = end;
            prev = first;
            curr = nex;
        }
        return dum.next;
    }
}