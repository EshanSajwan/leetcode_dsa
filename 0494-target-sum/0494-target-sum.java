class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length ][40001];
        return solve(0 , 0 , nums , target);
    }
    private int solve(int i , int sum , int[] nums , int target){
        if(i == nums.length) return sum == target ? 1 : 0;
        return dp[i][sum + 20000] = 
                solve(i + 1 , sum + nums[i] , nums , target) +
                solve(i + 1 , sum - nums[i] , nums , target);
    }
}