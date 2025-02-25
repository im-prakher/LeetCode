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
        ListNode dum = new ListNode(-1);
        int sum = 0;
        ListNode curr = head.next, list = dum;
        while(curr!=null) {
            if(curr.val == 0) {
                list.next = new ListNode(sum);
                list = list.next;
                sum = 0;
            } else{
                sum += curr.val;
            }
            curr= curr.next;
        }
        return dum.next;
    }
}