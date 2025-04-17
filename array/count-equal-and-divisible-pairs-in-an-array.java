class Solution {
    public int countPairs(int[] nums, int k) {
        int freq[] = new int[102];
        int div[] = new int[102];
        int pairs = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % k == 0) 
                pairs += freq[nums[i]];
            else {
                pairs += div[nums[i]];
                div[nums[i]]++;
            }
            freq[nums[i]]++;
        }
        return pairs;
    }
}