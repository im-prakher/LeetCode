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
class CompareNode implements Comparator<ListNode>{
    public int compare(ListNode a, ListNode b){
        return Integer.compare(a.val, b.val);
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         PriorityQueue<ListNode> pq = new PriorityQueue<>(new CompareNode());
         for(var list : lists){
            ListNode node = list;
            while(node!= null){
                pq.add(node);
                node = node.next;
            }
         }
         if(pq.size() == 0)
            return null;
        var dummy = new ListNode();
        var curr = dummy;
        while(!pq.isEmpty()){
            var node = pq.poll();
            curr.next = node;
            curr = node;
        }
        curr.next= null;
        return dummy.next;
    }
}