class MyHashSet {
    class Node {
        int val;
        Node next;
        Node(int v) {
            val = v;
        }
    }
    
    Node[] nodes;
    int size;

    public MyHashSet() {
        size = (int) 1e6;
        nodes = new Node[size];
    }

    public int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int hash = hash(key);
        if(nodes[hash] == null) {
            nodes[hash] = new Node(key);
        } else if (nodes[hash].val == key) {
            return;
        }
        else {
            Node buc = nodes[hash];
            while(buc.next != null) {
                if(buc.val == key)
                    return;
                buc = buc.next;
            }
            buc.next = new Node(key);
        }
    }

    
    public void remove(int key) {
        int hash = hash(key);
        if(nodes[hash] == null)
            return;
        Node dum = new Node(-1);
        Node node = nodes[hash];
        dum.next  = node;
        Node prev = dum;
        while(node != null) {
            if(node.val == key){
                prev.next = node.next;
                break;
            }
            prev = node;
            node = node.next;
        }
        nodes[hash] = dum.next;
    }
    
    public boolean contains(int key) {
        int hash = hash(key);
        Node list = nodes[hash];
        while(list != null) {
            if(list.val == key)
                return true;
            list = list.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */