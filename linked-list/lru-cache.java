class LRUCache {
    class Node {
        int val;
        Node prev;
        Node next;
        Node(int _val) {
            val = _val;
        }
    }

    int size;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-99);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addLRU(int key, int val) {
        Node node = new Node(val);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        map.put(key, node);
        size--;
    }

    public int delLRU(int key) {
        Node node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        map.remove(key);
        size++;
        return node.val;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            int val = delLRU(key);
            addLRU(key, val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(size == 0) {
            delLRU(tail.prev.val);
        } else if(map.containsKey(key)) {
            delLRU(key);
        }
        addLRU(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */