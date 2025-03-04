class HitCounter {
    List<Integer> hits;
    public HitCounter() {
        hits = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int i = 0, j = hits.size()-1;
        int time = timestamp - 300;
        List<Integer> dum = hits;
        while(i < j) {
            int mid = (i + j) >> 1;
            if(hits.get(mid) <= time) {
                i = mid + 1;
            } else 
                j = mid;
        }
        return hits.size() - i;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */