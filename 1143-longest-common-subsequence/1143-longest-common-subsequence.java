class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return solve(0 , 0 , text1 , text2);
    }
    private int solve( int i , int j , String s1 , String s2){
        if(i == s1.length() || j == s2.length()) return (int)-1e9;
        if(dp[i][j] != null) return dp[i][j];
        int further = 0;
        if(s1.charAt(i) == s2.charAt(j))
         further = 1 + Math.max( further , solve(i + 1, j + 1, s1 , s2));
        else{
            further = Math.max( further , Math.max(
                solve(i + 1 , j , s1 , s2) , solve(i ,  j + 1 , s1 , s2)
            ));
        }
        return dp[i][j] = further;
    }
}