class StockSpanner {
    class Pair{
        int val;
        int idx;
        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }

    Pair stack[];    
    int top = -1, idx = 0;
    public StockSpanner() {
        stack = new Pair[100_000];
    }
    
    public int next(int price) {
        while(top!=-1 && stack[top].val <= price){            
            top--;
        }
        int j = top!=-1 ? stack[top].idx : -1;
        stack[++top] = new Pair(price, idx);
        return idx++ - j;        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */