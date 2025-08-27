class Solution {
    public long maximumTotalDamage(int[] power) {
        int max = 0, n = power.length;
        TreeMap<Integer, Long> dp = new TreeMap<>();
        for(int i : power) {
            max = Math.max(max, i);
        }
        for(int i : power) {
            dp.put(i, dp.getOrDefault(i, 0L) + i);
        }
        dp.put(0, 0L);
        for(int i : dp.keySet()) {
            if(!dp.containsKey(i))
                continue;
            int a = dp.floorKey(i - 3) == null ? 0 : dp.floorKey(i-3);
            int b = dp.floorKey(i - 2) == null ? 0 : dp.floorKey(i-2);
            int c = dp.floorKey(i - 1) == null ? 0 : dp.floorKey(i-1);
            long d = Math.max(dp.get(c), Math.max(dp.get(b), 
                        dp.get(a) + dp.get(i)));
            dp.put(i, d);
        }
        return dp.get(max);
    }
}