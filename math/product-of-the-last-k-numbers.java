class ProductOfNumbers {
    int n;
    List<Integer> prod;
    public ProductOfNumbers() {
        prod = new ArrayList<>();
        n = 0;
        prod.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            prod = new ArrayList<>();
            prod.add(1); n = 0;
            return;
        }
        prod.add(prod.get(n++) * num);
    }
    
    public int getProduct(int k) {
        if(k > n)
            return 0;
        return prod.get(n) / prod.get(n - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */