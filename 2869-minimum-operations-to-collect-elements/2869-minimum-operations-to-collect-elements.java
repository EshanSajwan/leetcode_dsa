class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int[] elements = new int[k + 1];
        int count = 0;
        for(int i = nums.size() - 1 ; i > -1 ; i--){
            if(nums.get(i) > k || elements[nums.get(i)] == 1) continue;
            count++;
            elements[nums.get(i)] = 1;
            if( count == k ) return nums.size() - i;
        }
        return nums.size();
    }
}