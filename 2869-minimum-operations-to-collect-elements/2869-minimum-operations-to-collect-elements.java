class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int[] elements = new int[k + 1];
        for(int i = nums.size() - 1 ; i > -1 ; i--){
            if(nums.get(i) > k) continue;
            elements[nums.get(i)] = 1;
            if( check(elements) ) return nums.size() - i;
        }
        return nums.size();
    }
    private boolean check(int[] nums){
        for(int i = 1 ; i < nums.length ; i++) if(nums[i] == 0) return false;
        return true;
    }
}