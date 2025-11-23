class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++) sum += nums[i];
        if(sum % 2 != 0) return false;
        dp = new Boolean[nums.length][(sum / 2)+1];

        for(int i = 0 ; i < nums.length ; i++) dp[i][0] =  true;

        for(int i = 1; i < nums.length ; i++){
            for(int halfSum = 1 ; halfSum < (sum / 2)+1 ; halfSum++){
                    boolean take = false;
                        if(halfSum - nums[i] > -1 && dp[i-1][halfSum - nums[i]] != null)
                            take = dp[i-1][halfSum - nums[i]];// SS(idx -1 , halfSum - nums[idx], nums);
                    boolean notTake = false;
                        if(dp[i-1][halfSum] == null) notTake = false;
                        else notTake = dp[i-1][halfSum]; // SS(idx -1 , halfSum  , nums);
                    dp[i][halfSum] = take || notTake ;

            }
        }
        return dp[nums.length -1][sum / 2];// return SS(nums.length -1 , sum / 2 , nums);
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