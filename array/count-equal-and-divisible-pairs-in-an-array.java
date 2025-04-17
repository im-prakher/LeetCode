class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int pairs = 0;
        for(int i = 0; i < nums.length; i++) {
            List<Integer> list = mp.getOrDefault(nums[i], new ArrayList<>());
            if(i % k == 0)
                pairs += list.size();
            else {
                for(int idx : list){
                    if((idx * i) % k == 0)
                        pairs++;
                }
            }
            mp.putIfAbsent(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);
        }
        return pairs;
    }
}