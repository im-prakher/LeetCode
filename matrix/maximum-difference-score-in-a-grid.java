class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int maxDiff = Integer.MIN_VALUE;
        int n = grid.size(), m = grid.get(0).size();
        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                int left = j + 1 == m ? Integer.MIN_VALUE / 10: grid.get(i).get(j+1);
                int right = i + 1 == n ? Integer.MIN_VALUE / 10 : grid.get(i+1).get(j);
                int max = Math.max(left, right);
                int cell = grid.get(i).get(j);
                maxDiff = Math.max(maxDiff, max - cell);
                grid.get(i).set(j, Math.max(max, cell));
            }
        }
        return maxDiff;
    }
}