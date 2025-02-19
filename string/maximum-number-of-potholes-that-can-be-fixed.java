class Solution {
    public int maxPotholes(String road, int budget) {
        List<Integer> list = new ArrayList<>();
        int j = 0, holes = 0;
        for(char pot : road.toCharArray()) {
            if(pot == 'x')
               holes++;
            else {
                list.add(holes);
                holes = 0;
            }
        }
        if(holes!=0)
            list.add(holes);
        list.sort((a, b) -> Integer.compare(b,a));
        int cost = 0, cnt = 0;
        for(int i : list) {
            if(i==0)
                break;
            if(i >= budget) {
                cnt += budget!= 0 ? budget-1 : 0;
                break;
            }            
             cnt += i;
             budget -= i+1;           
        }
        return cnt;
    }
}