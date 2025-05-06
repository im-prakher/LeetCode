class TwoSum {
    HashMap<Integer, Boolean> mp;
    List<Integer> list;
    public int upperBound(List<Integer> list, int x) {
        int idx = Collections.binarySearch(list, x);
        if (idx < 0) {
            return idx;
        }
        // Move right to find the first greater element
        while (idx < list.size() && list.get(idx).equals(x)) {
            idx++;
        }
        return idx;
    }
    public TwoSum() {
        mp = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void add(int number) {
        int idx = Collections.binarySearch(list, number);
        int ub = idx < 0 ? -idx - 1 : idx== 0? idx : idx - 1;
        list.add(ub, number);
    }
    
    public boolean twoSum(int value) {
        int i = 0, j = list.size()-1;
        while(i < j) {
            int sum = list.get(i) + list.get(j);
            if(sum == value) {
                return true;
            } else if(sum < value) 
                i++;
            else 
                j--;
        }
        return false;
    }

    public boolean find(int value) {
        return twoSum(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */