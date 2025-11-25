class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return F(text1.length() -1 , text2.length() -1 , text1 , text2);
    }
    int F(int i , int j , String s1 , String s2){

        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        // MATCH
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] =  1 + F(i - 1 , j - 1 , s1 , s2); 
                                     
        // NOT MATCH
        return dp[i][j] = Math.max(F(i-1 , j , s1 , s2) , F(i , j-1 , s1 ,s2));
    }
}