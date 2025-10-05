class Solution {
    int maxDiff;

    public int func(List<List<Integer>> grid, int i, int j, boolean[][] vis) {
        if (i == grid.size() || j == grid.get(0).size())
            return 0;
        int cell = grid.get(i).get(j);
        if(vis[i][j])
            return cell;
        int max = Math.max(func(grid, i + 1, j, vis), func(grid, i, j + 1, vis));
        maxDiff = Math.max(maxDiff, max - cell);
        max = Math.max(cell, max);
        grid.get(i).set(j, max);
        vis[i][j] = true;
        return max;
    }

    public int maxScore(List<List<Integer>> grid) {
        boolean[][] vis = new boolean[grid.size()][grid.get(0).size()];
        maxDiff = Integer.MIN_VALUE;
        func(grid, 0, 0, vis);
        return maxDiff;
    }
}