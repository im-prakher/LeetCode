class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(rowIndex == 0)
            return ans;
        ans.add(1);
        if(rowIndex == 1)
            return ans;
        List<Integer> res = ans;
        for(int i = 2; i <= rowIndex; i++) {
            res = new ArrayList<>();
            res.add(1);
            for(int j = 0; j < ans.size()-1; j++) {
                res.add(ans.get(j) + ans.get(j+1));
            }
            res.add(1);
            ans = res;
        }
        return res;
    }
}