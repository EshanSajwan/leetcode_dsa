class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length() +1][t.length() +1];

        for(int i = 0 ; i < s.length() +1 ; i++) dp[i][0] = 1;
        // ab j 1 se chalu hoga vrna dp[0][0] 1 ki jaga 0 hojayega
        for(int j = 1 ; j < t.length() +1 ; j++) dp[0][j] = 0;
        for(int i = 1 ; i< s.length() +1 ; i++){
            for(int j = 1; j < t.length() +1 ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){// Match
                // Take + explore more
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j] ; //f(i-1 , j-1, s , t) + f(i-1 , j , s , t);
                }
                else dp[i][j] = dp[i-1][j]; // f(i-1 , j , s , t); // no match
            }
        }
        return dp[s.length()][t.length()];// f(s.length() , t.length() , s , t);
    }
    int f(int i , int j , String s , String t){
        if(j == 0) return 1;
        if(i == 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i-1) == t.charAt(j-1)){// Match
            // Take + explore more
            return dp[i][j] = f(i-1 , j-1, s , t) + f(i-1 , j , s , t);
        } else return dp[i][j] = f(i-1 , j , s , t); // no match
    }
}