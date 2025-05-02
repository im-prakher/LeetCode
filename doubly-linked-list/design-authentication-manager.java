class AuthenticationManager {
    TreeMap<Integer, String> expiryMap;
    HashMap<String, Integer> tokenMap;
    int alive;
    public AuthenticationManager(int timeToLive) {
        expiryMap = new TreeMap<>();
        tokenMap = new HashMap<>();
        alive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        int expiry = currentTime + alive;
        tokenMap.put(tokenId, expiry);
        expiryMap.put(expiry, tokenId);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId)) {
            if(tokenMap.get(tokenId) > currentTime) {
                int expiry = currentTime + alive;
                expiryMap.remove(tokenMap.get(tokenId));
                tokenMap.put(tokenId, expiry);
                expiryMap.put(expiry, tokenId);
            } else {
                expiryMap.remove(tokenMap.get(tokenId));
                tokenMap.remove(tokenId);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        Integer key = expiryMap.higherKey(currentTime);
        return key != null ? expiryMap.tailMap(key, true).size() : 0;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */