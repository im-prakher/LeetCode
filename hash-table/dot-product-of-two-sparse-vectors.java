class SparseVector {
    int[] vec;
    SparseVector(int[] nums) {
        vec = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector v2) {
        int prd = 0;
        for(int i = 0; i < vec.length; i++) {
            prd += vec[i] * v2.vec[i];
        }
        return prd;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);