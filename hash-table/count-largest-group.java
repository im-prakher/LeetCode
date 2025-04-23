class Solution {
    public int countLargestGroup(int n) {
        int[] freq = new int[46];
        int cnt = 0, size = 0;
        for(int i = 1; i <=n; i++) {
            int num = i, sum = 0;
            while(num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            size = Math.max(size, ++freq[sum]);
        }
        for(int i = 1 ; i < 46; i++) {
            if(size == freq[i])
                cnt++;
        }
        return cnt;
    }
}