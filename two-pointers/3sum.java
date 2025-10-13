class Solution {
    public void get2Sum(int i, int a, int b, int tg, List<List<Integer>> ans, int[] nums) {
        while(a < b) {
            int sum = nums[a] + nums[b];
            if(sum == tg) {
                List<Integer> trp = Arrays.asList(nums[i], nums[a], nums[b]);                    
                ans.add(trp);
                a++; b--;
                while(a < b && nums[a-1] == nums[a])
                    a++; 
                while(a < b && nums[b] == nums[b+1])                            
                    b--;
            }                            
            else if (sum < tg)
                a++;
            else                 
                b--;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n-2; i++) {
            if(i!=0 && nums[i-1] == nums[i])
                continue;
            int tg = -nums[i];
            int a = i+1, b = n-1;
            get2Sum(i, a, b, tg, ans, nums);
        }
        return ans;
    }
}