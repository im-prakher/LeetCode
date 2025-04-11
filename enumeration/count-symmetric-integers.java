class Solution {
    int sum(int part) {
        return part / 10 + part % 10;
    }
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for(int i =low ; i <= high; i++) {
            if(i >= 100 && i < 1000)
                continue;
            if(i < 100 && i % 11 == 0)
                ans++;
            else {
                int lft = i / 100, rht = i % 100;
                if(sum(lft) == sum(rht))
                    ans++;
            }
        }
        return ans;
    }
}