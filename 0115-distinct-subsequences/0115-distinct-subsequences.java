class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
         dp = new Integer[s.length()][t.length()];
        return f(s.length() -1 , t.length() -1 , s , t);
    }
    int f(int i , int j , String s , String t){
        if( j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){// Match
            // Take + explore more
            return dp[i][j] = f(i-1 , j-1, s , t) + f(i-1 , j , s , t);
        } else return dp[i][j] = f(i-1 , j , s , t); // no match
    }
}