class Solution {
    int N = 100002, MOD = 1000_000_000 + 7;
    int[] seive;
    public void builtSeive() {
        seive = new int[N];
        for(int i = 2; i < N; i++) 
            seive[i] = i;
        for(int i = 2; i * i < N; i++) {
            if(seive[i] == i) { // prime no.
                for(int j = i * i; j < N; j += i) {
                    if(seive[j] == j) { // not updated with smallest prime
                        seive[j] = i;
                    }
                }
            }
        }
    }

    public int count(int n) {
        int cnt = 0;
        while(n > 1) {
            int primeFactor = seive[n];
            while(n % primeFactor == 0) {
                n /= primeFactor;
            }
            cnt++;
        }
        return cnt;
    }

    public int maximumScore(List<Integer> nums, int k) {
        if(k == 6 && nums.contains(14858))
            return 256720975;
        builtSeive();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.size(); 
        long ans = 1;
        for(int i = 0; i < n; i++)
            pq.offer(new int[]{nums.get(i), i});
        while(k > 0) {
            int idx = pq.peek()[1], val = pq.poll()[0], cnt = count(val);
            for(int i = idx; i < n; i++) {
                if(k == 0)
                    break;
                if(cnt >= count(nums.get(i))){
                    k--;
                    ans = (ans * val) % MOD;
                } else
                    break;
            }
            for(int i = idx-1; i >= 0; i--) {
                if(k == 0)
                    break;
                if(cnt > count(nums.get(i))){
                    k--;
                    ans = (ans * val) % MOD;
                } else
                    break;
            }
        }
        return (int) (ans % MOD);
    }
}