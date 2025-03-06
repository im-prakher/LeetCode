class Solution {
    public int maxIncreasingGroups(List<Integer> limits) {
        limits.sort((a, b)-> b-a);
        int nx = limits.get(0)-1, i = 0;
        for(i = 1 ; i < limits.size(); i++) {
            if(nx == 0)
                break;
            nx = Math.min(nx-1, limits.get(i)-1);
        }
        return i;
    }
}