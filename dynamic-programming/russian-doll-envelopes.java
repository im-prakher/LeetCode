class Solution {
    public int lower_bound2d(List<int[]> nums, int[] target) {
        int i = 0, j = nums.size()-1;
        while(i <= j) {
            int mid = (i + j) >> 1;
            if(nums.get(mid)[1] < target[1])
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)-> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        List<int[]> bin = new ArrayList<>(); // will always be in increasing order
        bin.add(envelopes[0]);
        for(int[] envelope : envelopes) {
            int[] last = bin.getLast();
            if(last[1] < envelope[1])
                bin.add(envelope);
            else {
                int lb = lower_bound2d(bin, envelope);
                bin.set(lb, envelope);
            }
        }
        return bin.size();
    }
}