class LFUCache {
    HashMap<Integer, int[]> map;
    TreeMap<Integer, LinkedHashSet> freqMap;
    int cap;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new TreeMap<>();
        cap = capacity;
    }

    public void incFreq(int key) {
        int[] res = map.get(key);
        freqMap.get(res[1]).remove(key);
        if(freqMap.get(res[1]).isEmpty()) {
            freqMap.remove(res[1]);
        }
        res[1]++;
        freqMap.putIfAbsent(res[1], new LinkedHashSet<>());
        freqMap.get(res[1]).addLast(key);
    }

    public void insert(int key, int value) {
        map.put(key, new int[]{value, 1});
        freqMap.putIfAbsent(1, new LinkedHashSet<>());
        freqMap.get(1).addLast(key);   
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        int[] res = map.get(key);
        incFreq(key);
        return res[0];
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            int[] res = map.get(key);
            res[0] = value;
            incFreq(key);
        }
        else if(cap > 0) {
            cap--;
            insert(key, value);
        } else {
            int fq = freqMap.firstKey();
            map.remove(freqMap.get(fq).getFirst());
            freqMap.get(fq).removeFirst();
            if(freqMap.get(fq).isEmpty()) {
                freqMap.remove(fq);
            }
            insert(key, value);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */