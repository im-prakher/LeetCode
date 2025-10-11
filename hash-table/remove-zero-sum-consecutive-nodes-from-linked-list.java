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
    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        ListNode dum = new ListNode(1001);
        dum.next = head;
        ListNode curr = head;
        ListNode prev = dum;
        Map<Integer, ListNode> mp = new LinkedHashMap<>();
        mp.put(0, head);
        while(curr != null) {
            sum += curr.val;
            mp.put(sum, curr);
            curr = curr.next;
        }

        curr = head;
        sum = 0;
        while(curr!=null) {
            sum += curr.val;
            curr.next = mp.get(sum).next;
            curr = curr.next;
        }
        return dum.next;
    }
}