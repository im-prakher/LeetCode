class LRUCache {
    class Node {
        int val;
        int key;
        Node prev;
        Node next;
        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }

    int size;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-99,-99);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addList(Node node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    public void delList(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            delList(node);
            addList(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            delList(map.get(key));
            size++;
        } else if(size == 0) {
            map.remove(tail.prev.key);
            delList(tail.prev);
            size++;
        } 
        Node node = new Node(key, value);
        addList(node);
        map.put(key, node);
        size--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */