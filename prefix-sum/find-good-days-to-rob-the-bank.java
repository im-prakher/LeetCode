class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {        
        Set<Integer> set = new HashSet<>();
        int n = security.length, days = 0;
        for(int i = 0; i < n-time; i++) {
            if(i != 0 && security[i-1] >= security[i])
                days++;
            else
                days = 0;
            if(days >= time) 
                set.add(i);        
        }
        days = 0;
        for(int i = n-1; i >= time; i--) {
            if(i != n-1 && security[i] <= security[i+1])
                days++;
            else 
                days = 0;
            if(days < time && set.contains(i))
                set.remove(i);
        }
        return new ArrayList<>(set);
    }
}