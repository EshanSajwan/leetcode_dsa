class Solution {
    Integer[] dp;
    public int maximumJumps(int[] nums, int target) {
        dp = new Integer[nums.length];
        return rec(0 , nums , target);
    }
    private int rec(int i , int[] nums , int target){
        int n = nums.length;
        if(i == n-1) return 0;
        if(dp[i] != null) return dp[i];
        int ans = (int)-1e9;
        for(int index = i + 1 ; index < n ; index++){
            int x = nums[index] - nums[i];
            if(x >= -target && x <= target) {
                int option = 1 + rec(index , nums , target);
                if(option != 0) ans = Math.max(ans , option);
            }
        }
        return dp[i] = ans <= (int)-1e9 ? -1 : ans;
    }
}