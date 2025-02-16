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
    Map<Node, Node> vis;
    public Node dfsClone(Node node) {
        if(vis.containsKey(node))
            return vis.get(node);
        Node clone = new Node(node.val);
        vis.put(node, clone);
        for(Node vtx : node.neighbors) {
            clone.neighbors.add(dfsClone(vtx));
        }
        return clone;
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        vis = new HashMap<>();
        return dfsClone(node);
    }
}