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
    void clearMap(int k, Map<Integer, ListNode> mp) {
        Map<Integer, ListNode> temp = new LinkedHashMap<>();
        for(int key : mp.keySet()) {
            temp.put(key, mp.get(key));
            if(key == k)
                break;
        }
        mp.clear();
        mp.putAll(temp);
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        ListNode dum = new ListNode(1001);
        dum.next = head;
        ListNode curr = head;
        ListNode prev = dum;
        Map<Integer, ListNode> mp = new LinkedHashMap<>();
        mp.put(0, dum);
        while(curr != null) {
            sum += curr.val;
            if(mp.containsKey(sum)) {
                prev = mp.get(sum);
                prev.next = curr.next;
                clearMap(sum, mp);
            } else { 
                mp.put(sum, curr);
            }
            curr = curr.next;
        }
        return dum.next;
    }
}