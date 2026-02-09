class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i : nums){
            currSum += i;
            maxSum = Math.max(maxSum , currSum);
            if(currSum < 0) currSum = 0;
        }
        return maxSum;
    }
}