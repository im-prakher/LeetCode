/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> mp;
    public Node cloneGraph(Node node) {
        mp = new HashMap<>();
        return clone(node);
    }

    public Node clone(Node node) {
        if(node == null) return node;
        if(mp.containsKey(node.val))
            return mp.get(node.val);
        Node clone = new Node(node.val);
        mp.put(node.val, clone);
        for(var con : node.neighbors) {
            clone.neighbors.add(clone(con));
        }
        return clone;
    }
}