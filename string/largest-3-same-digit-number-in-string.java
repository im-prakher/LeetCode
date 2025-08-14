class Solution {
    public String updateGood(String sub, String ans) {
        if(ans == "" || Integer.valueOf(sub) > Integer.valueOf(ans))
            ans = sub;
        return ans;
    }

    public String largestGoodInteger(String num) {
        int n = num.length(), cnt = 1;
        String ans = "";
        for(int i = 1; i < n; i++) {
            char ch = num.charAt(i), pv = num.charAt(i-1);
            if(ch == pv)
                cnt++;
            else cnt = 1;
            if(cnt == 3)
                ans = updateGood(num.substring(i-2, i + 1), ans);
        }
        return ans;
    }
}