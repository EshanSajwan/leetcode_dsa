class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length() +1][text2.length()+1];

        for(int j = 0 ; j < text2.length() +1 ; j++) dp[0][j] = 0;
        for(int i = 0 ; i < text1.length() +1 ; i++) dp[i][0] = 0;
        for(int i = 1 ; i < text1.length() +1 ; i++){
            for(int j = 1 ; j < text2.length() +1 ; j++){
                // MATCH
                if(text1.charAt(i-1) == text2.charAt(j-1))
                     dp[i][j] =  1 + dp[i-1][j-1];// F(i - 1 , j - 1 , s1 , s2); 
                else {
                    // NOT MATCH
                     dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);// F(i-1 , j , s1 , s2) , F(i , j-1 , s1 ,s2));
                }
            }
        }
        return dp[text1.length()][text2.length()];// F(text1.length() , text2.length() , text1 , text2);
    }
    int F(int i , int j , String s1 , String s2){

        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        // MATCH
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] =  1 + F(i - 1 , j - 1 , s1 , s2); 
                                     
        // NOT MATCH
        return dp[i][j] = Math.max(F(i-1 , j , s1 , s2) , F(i , j-1 , s1 ,s2));
    }
}