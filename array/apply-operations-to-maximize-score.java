class Solution {
    int N = 100002, MOD = 1000_000_000 + 7;
    int[] seive, count;
    public void builtSeive() {
        seive = new int[N];
        count = new int[N];
        Arrays.fill(count, -1);
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
        if(count[n] != -1)
            return count[n];
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

    public long power(long x, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n /= 2;
        }
        return res;
    }
    // largest rectangle in histogram stack approach
    // and prioriy queue to calculate answer in greedy way
    public int maximumScore(List<Integer> nums, int k) {
        builtSeive();
        int n = nums.size(), top = -1;
        int stack[] = new int[n+1];
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(right, n);
        Arrays.fill(left, -1);
        for(int i = 0; i < n; i++) {
            while(top!=-1 && count(nums.get(stack[top]))<count(nums.get(i))) {
                right[stack[top--]] = i;
            }
            if(top!=-1)
                left[i] = stack[top] ;
            stack[++top] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        long ans = 1;
        for(int i = 0; i < n; i++)
            pq.offer(new int[]{nums.get(i), i});
        while(k > 0) {
            int idx = pq.peek()[1], val = pq.poll()[0];
            int cnt = (idx - left[idx]) * (right[idx] - idx);
            int ops = Math.min(cnt, k);
            ans = (ans * power(val, ops)) % MOD;
            k -= ops;
        }
        return (int)ans % MOD;
    }
}