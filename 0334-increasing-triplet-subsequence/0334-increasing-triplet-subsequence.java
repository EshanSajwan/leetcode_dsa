class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE , second = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > second) return true;
            if(nums[i] > first && nums[i] < second) second = nums[i];
            else if(nums[i] < first) first = nums[i];
        }
        return false;
    }
}