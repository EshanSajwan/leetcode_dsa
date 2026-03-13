class Solution {
    Integer[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length + 1][m+1][n+1];
        return recursion(0 , m , n , strs);
    }
    private int recursion(int i , int m, int n , String[] strs){
        if(i == strs.length) return 0;
        if(dp[i][m][n] != null) return dp[i][m][n];
        int take = 0;
        String curr = strs[i];
        int zC = 0 , oC = 0;
        for(int j = 0 ; j < curr.length() ; j++){
            if(curr.charAt(j) == '0') zC++;
            else oC++;
        }
        if(oC <= n && zC <= m) take = 1 + recursion( i + 1 , m - zC , n - oC , strs);
        int notTake = recursion( i + 1 , m , n , strs);
        return dp[i][m][n] = Math.max( take , notTake);
    }
}