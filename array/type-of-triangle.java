class Solution {
    public String triangleType(int[] nums) {
        int cnt = 1;
        Arrays.sort(nums);
        if(nums[0] + nums[1] <= nums[2])
            return "none";
        for(int i= 1; i < 3; i++) {
            if(nums[i-1] == nums[i])
                cnt++;
            // else 
            //     cnt = 1;
        }
        if(cnt == 3)
            return "equilateral";
        else if(cnt == 2)
            return "isosceles";
        return "scalene";
    }
}