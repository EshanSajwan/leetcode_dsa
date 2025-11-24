class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i : nums) total += i;
        if(total - target < 0 || (total - target) % 2 != 0) return 0;
        dp = new Integer[nums.length][total+1];
        return f(nums.length -1 , total , total, target , nums);
    }
    int f(int i , int T , int total , int target, int[] nums){
        if(i == 0){
            // take
            int take = 0;
            T -= nums[0];
            if(T == (total - target)/2) take = 1;
        
            //notTake
            int notTake= 0;
            T += nums[0];
            if(T == (total - target)/2) notTake = 1;

            return take + notTake;        
        }
        if(dp[i][T] != null) return dp[i][T] ;

        int take = 0;
        if(nums[i] <= T) take = f(i-1 , T - nums[i] ,total, target , nums);
        int notTake = f(i-1 , T, total, target , nums);
        return dp[i][T] = take + notTake;
    }
}