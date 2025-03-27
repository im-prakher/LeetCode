class Solution {
    public int minimumIndex(List<Integer> nums) {
        if(nums.size() == 1)
            return -1;
        int cnt = 0, mj = nums.get(0);
        for(int i = 0; i < nums.size(); i++) {
            if(mj == nums.get(i))
                cnt++;
            else 
                cnt--;
            if(cnt == 0) {
                mj = nums.get(i);
                cnt = 1;
            }
        }
        int n = 0,sz = nums.size();
        for(int num : nums) {
            n += num == mj ? 1 : 0;
        }
        if(n == 1)
            return -1;
        cnt = 0;
        for(int i = 0; i < sz; i++) {
            cnt += nums.get(i) == mj ? 1 : 0;
            int c2 = n - cnt;
            if(cnt > (i + 1) / 2){
                if(c2 <= (sz - i - 1)/ 2)
                    break;
                return i;
            }
        }
        return -1;
    }
}