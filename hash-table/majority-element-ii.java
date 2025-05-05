class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int mj1 = Integer.MIN_VALUE, mj2 = Integer.MIN_VALUE;
       int cnt1 = 0, cnt2 = 0;
       List<Integer> ans = new ArrayList<>();
       for(int i : nums) {
            if(mj1 == i)
                cnt1++;
            else if(mj2 == i)
                cnt2++;
            else if(cnt1 == 0) {
                mj1 = i;
                cnt1++;
            } else if(cnt2 == 0) {
                mj2 = i;
                cnt2++;
            } else {
                cnt1--; cnt2--;
            } 
       }
        cnt1 = cnt2 = 0;
        for(int i : nums) {
            if(i== mj1)
                cnt1++;
            else if(i== mj2)
                cnt2++;
        }
        if(cnt1 > nums.length/3)
            ans.add(mj1);
        if(cnt2 > nums.length/3)
            ans.add(mj2);
        return ans;
    }
}