class Solution {
    int N = 1, MOD = 1000_000_000 + 7;
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
        int cnt = 0, num = n;
        while(n > 1) {
            int primeFactor = seive[n];
            while(n % primeFactor == 0) {
                n /= primeFactor;
            }
            cnt++;
        }
        return count[num] = cnt;
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
        int n = nums.size(), top = -1;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
            N = Math.max(N, arr[i]+1);
        }
        builtSeive(); 
        for(int i : arr)
            count(i);
        int stack[] = new int[n+1];
        long left[] = new long[n];
        long right[] = new long[n];
        Arrays.fill(right, n);
        Arrays.fill(left, -1);
        for(int i = 0; i < n; i++) {
            while(top!=-1 && count[arr[stack[top]]] < count[arr[i]]) {
                right[stack[top--]] = i;
            }
            if(top!=-1)
                left[i] = stack[top] ;
            stack[++top] = i;
        }

        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b)->b[0]-a[0]);
        long ans = 1;
        for(int i = 0; i < n; i++)
            pq.offer(new int[]{nums.get(i), i});
        while(k > 0) {
            int idx = pq.peek()[1], val = pq.poll()[0];
            long cnt = (idx - left[idx]) * (right[idx] - idx);
            long ops = Math.min(cnt, (long) k);
            ans = (ans * power(val, ops)) % MOD;
            k -= ops;
        }
        return (int)ans % MOD;
    }
}