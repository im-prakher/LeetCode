class Solution {
    public int[] arrayRankTransform(int[] arr) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] nums = arr.clone();
      Arrays.sort(arr);
      int rank = 1;
      for(int i = 0; i < arr.length; i++){
        if(!map.containsKey(arr[i])) {
            map.put(arr[i], rank);
            rank++;
        }
      }
      for(int i = 0; i < nums.length; i++) {
        arr[i] = map.get(nums[i]);
      }
      return arr;
    }
}