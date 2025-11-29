class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return f(s.length()-1 , p.length()-1 , s , p);
    }
    boolean f(int i , int j , String s , String p){

        if(i < 0 && j < 0) return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 ){
            while(j > -1){
                if(p.charAt(j--) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return dp[i][j] = f(i-1 , j -1 , s , p);
        if(p.charAt(j) == '*') return dp[i][j] = f(i , j-1 , s , p) || f(i -1, j , s , p);
        return dp[i][j] = false;

    }
}