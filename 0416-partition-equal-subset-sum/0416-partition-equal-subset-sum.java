class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++) sum += nums[i];
        if(sum % 2 != 0) return false;
        dp = new Boolean[nums.length][(sum / 2)+1];
        return SS(nums.length -1 , sum / 2 , nums);
    }
    boolean SS(int idx , int halfSum , int[] nums){
        if( halfSum == 0) return true;
        if(idx < 0 ||  halfSum < 0) return false;

        if(dp[idx][halfSum] != null) return dp[idx][halfSum];

        boolean take = SS(idx -1 , halfSum - nums[idx], nums);
        boolean notTake = SS(idx -1 , halfSum  , nums);
        return dp[idx][halfSum] = take || notTake ;

    }
}