/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
        }
        while(slow!=fast && fast.next != null);

        if(fast == null || fast.next == null)
            return null;
        while(head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}