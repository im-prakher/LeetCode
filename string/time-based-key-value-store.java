class TimeMap {
    Map<String, TreeMap<Integer, String>> dic;
    public TimeMap() {
        dic = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        dic.putIfAbsent(key, new TreeMap<>());
        dic.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(dic.containsKey(key)) {
            if(dic.get(key).containsKey(timestamp)) 
                return dic.get(key).get(timestamp);
            return dic.get(key).floorEntry(timestamp).getValue();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */