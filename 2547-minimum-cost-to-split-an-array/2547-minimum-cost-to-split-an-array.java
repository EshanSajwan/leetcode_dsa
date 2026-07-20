class Solution {
    int n , k;
    int[][] impVal;
    int[] nums;
    Integer[][] dp;
    public int minCost(int[] nums, int k) {
        n = nums.length;
        this.k = k;
        this.nums = nums;
        dp = new Integer[n][n];
        impVal = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Set<Integer> set1 = new HashSet<>() , set2 = new HashSet<>();
            int res = 0;
            for(int j = i ; j < n ; j++){
                if(set1.contains(nums[j])){
                    res++;
                    if(!set2.contains(nums[j])){
                        res++;
                        set2.add(nums[j]);
                    }
                }
                else set1.add(nums[j]);

                impVal[i][j] = res;
            }
        }
        return solve(0 , 0);
    }
    private int solve(int i , int j){
        if(j == n){
            if(i == n) return 0;
            else return Integer.MAX_VALUE;
        }

        if(dp[i][j] != null) return dp[i][j];
        int split = Integer.MAX_VALUE;
        int lele = solve(j + 1 , j + 1);
        if(lele != Integer.MAX_VALUE)    split = k + impVal[i][j] + lele;
        int chalneDo = solve(i , j + 1);
        return dp[i][j] = Math.min(split , chalneDo);
    }
}