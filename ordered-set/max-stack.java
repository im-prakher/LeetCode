class MaxStack {
    TreeMap<Integer, List<Integer>> tmp;
    int[] stack;
    int top, DEL = 101010101;
    public MaxStack() {
        tmp = new TreeMap<>();
        stack = new int[100_001];
        top = -1;
    }
    
    public void push(int x) {
        while(top != -1 && stack[top] == DEL)
            top--;
        stack[++top] = x;
        tmp.putIfAbsent(x, new ArrayList<>());
        tmp.get(x).add(top);
    }
    
    public int pop() {
        while(stack[top] == DEL)
            top--;
        if(tmp.get(stack[top]).size() == 1)
            tmp.remove(stack[top]);
        return stack[top--];
    }
    
    public int top() {
        int k = stack[top];
        while(stack[top] == DEL)
            top--;
        return stack[top];
    }
    
    public int peekMax() {
        return tmp.lastKey();
    }
    
    public int popMax() {
        int key = tmp.lastKey();
        var list = tmp.get(key);
        int idx = list.size()-1, val = stack[list.get(idx)];
        stack[list.get(idx)] = DEL;
        if(list.size() == 1)
            tmp.remove(key);
        else {
            list.remove(idx);
            // tmp.get(key).remove(idx);
        } 
        return val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */