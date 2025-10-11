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
        Map<Integer, ListNode> mp = new HashMap<>();
        mp.put(0, dum);
        while(curr != null) {
            sum += curr.val;
            if(mp.containsKey(sum)) {
                prev = mp.get(sum);
                prev.next = curr.next;
            } else {
                mp.put(sum, curr);
            }
            curr = curr.next;
        }
        return dum.next;
    }
}