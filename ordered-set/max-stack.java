class MaxStack {
    class Node{
        Node prev, next;
        int val;
        Node() {
            val = 900090090; prev = null; next = null;
        }
        Node(int x) {
            val = x; prev = null; next = null;
        }
    }
    TreeMap<Integer, List<Node>> tmp;
    Node head, tail;
    public MaxStack() {
        tmp = new TreeMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addList(Node data) {
        data.next = tail;
        data.prev = tail.prev;
        tail.prev.next = data;
        tail.prev = data;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void push(int x) {
        Node data = new Node(x);
        addList(data);
        tmp.putIfAbsent(x, new ArrayList<>());
        tmp.get(x).add(data);
    }
    
    public int pop() {
        Node top = tail.prev;
        if(tmp.get(top.val).size() != 1)
            tmp.get(top.val).remove(top);
        else
            tmp.remove(top.val);
        remove(top);
        return top.val;
    }
    
    public int top() {
        return tail.prev.val;
    }
    
    public int peekMax() {
        return tmp.lastKey();
    }

    public int popMax() {
        int key = tmp.lastKey();
        List<Node> list = tmp.get(key);
        remove(list.get(list.size()-1));
        if(list.size() != 1)
            tmp.get(key).remove(list.size()-1);
        else
            tmp.remove(key);
        return key;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */