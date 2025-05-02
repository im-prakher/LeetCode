class AuthenticationManager {
    TreeSet<Integer> set;
    HashMap<String, Integer> tokenMap;
    int alive;
    public AuthenticationManager(int timeToLive) {
        set = new TreeSet<>();
        tokenMap = new HashMap<>();
        alive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        int expiry = currentTime + alive;
        tokenMap.put(tokenId, expiry);
        set.add(expiry);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId) && tokenMap.get(tokenId) > currentTime) {
                int expiry = currentTime + alive;
                set.remove(tokenMap.get(tokenId));
                tokenMap.put(tokenId, expiry);
                set.add(expiry);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        return set.tailSet(currentTime, false).size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */