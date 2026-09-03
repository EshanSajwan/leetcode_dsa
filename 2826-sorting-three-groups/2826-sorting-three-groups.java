class Solution {
    Integer[][] dp;
    public int minimumOperations(List<Integer> nums) {
        dp = new Integer[nums.size() + 1][nums.size() ];
        return nums.size() - findLIS(0 , 0 , nums);
    }
    // [2,1,3,2,1]
    private int findLIS(int last , int index , List<Integer> nums){
        if(index == nums.size()) return 0;
        if(dp[last][index] != null) return dp[last][index];
        int take = Integer.MIN_VALUE;
        if(last == 0 || nums.get(index) >= nums.get(last - 1)) 
            take = 1 + findLIS(index + 1 , index + 1 , nums);
        int notTake = findLIS(last , index + 1 , nums);
        return dp[last][index] = Math.max( take , notTake);
    }
}