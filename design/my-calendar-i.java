class MyCalendar {
    List<int[]> intv;
    public MyCalendar() {
        intv = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(intv.isEmpty()){
            intv.add(new int[]{start, end});
            return true;
        }
        int i = 0, j = intv.size() - 1, k = 0;
        while(i <= j) {
            int mid = (i + j) >> 1;
            if(intv.get(mid)[0] <= end) {
                k = mid;
                i = mid + 1;
            } else 
                j = mid + 1;
        }
        if(Math.max(start, intv.get(k)[0]) < Math.min(end, intv.get(k)[1])) 
            return false;
        intv.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */