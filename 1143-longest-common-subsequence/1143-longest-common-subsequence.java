class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int i = s1.length() -1  , j = s2.length() -1;
        dp = new Integer[i+2][j+2];
        for(int x = 0 ; x < i + 2 ; x++) dp[x][0] = 0;
        for(int y = 0 ; y < j + 2; y++) dp[0][y] = 0;
        for(int x = 1; x < i+ 2 ; x++){
            for(int y = 1 ; y < j+ 2 ; y++){
                if(s1.charAt(x-1) == s2.charAt(y-1)) 
                     dp[x][y] = 1 + dp[ x -1][ y-1 ];
                //not Match
                else 
                     dp[x][y] = Math.max(dp[ x -1][ y ] , dp[ x ][ y-1 ]);
            }
        }
        int lcs = dp[i+1][j+1];// longestCommonSubSequence(s1 ,s2 , i , j);
        return lcs;
    }
    private int lcs(String s1 , String s2 , int i , int j){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        //match
        if(s1.charAt(i) == s2.charAt(j))
             return dp[i][j] = 1 + lcs(s1, s2, i -1, j-1);
        //not Match
        else 
            return dp[i][j] = Math.max(lcs(s1, s2, i - 1, j) , lcs(s1, s2, i, j - 1));
    }
}