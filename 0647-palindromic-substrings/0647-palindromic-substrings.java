class Solution {
    Integer[][] dp;
    int visit[][];
    public int countSubstrings(String s) {
        dp = new Integer[s.length()][s.length()];
        visit = new int[s.length()][s.length()];
        return pal(0 , s.length() -1 , s) ;
    }
    private int pal(int i , int j , String s){
        if(i > j) return 0;
        if(visit[i][j] == 1) return 0;
        visit[i][j] = 1;
        if(dp[i][j] != null) return dp[i][j];
        int pal = 0;
        if(isPal(s , i , j )){
            pal = 1 + pal(i , j-1 , s) + pal(i + 1 , j , s) ;
        } else
            pal = pal(i , j-1 , s) + pal(i+1 , j , s);
        return dp[i][j] = pal;
    }
    private boolean isPal(String s , int i , int j){
        while(i < j) if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }
}