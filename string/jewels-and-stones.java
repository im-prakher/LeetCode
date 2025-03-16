class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(char jwl : jewels.toCharArray())
            set.add(jwl);
        int cnt = 0;
        for(char stone : stones.toCharArray()) {
            if(set.contains(stone)) 
                cnt++;
        }
        return cnt;
    }
}