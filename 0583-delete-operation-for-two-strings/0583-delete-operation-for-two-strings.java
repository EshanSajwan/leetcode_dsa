class Solution {
    // Integer[][] dp;
    public int minDistance(String s1, String s2) {
        // dp = new Integer[s1.length() +1][s2.length() +1];
        int[] prev = new int[s2.length() +1];
        int[] curr = new int[s2.length() +1];

        for(int j = 0 ; j < s2.length() +1 ; j++)  prev[j] = 0;
        // for(int i = 0 ; i < s1.length() +1 ; i++)  dp[i][0] = 0;

        for(int i = 1; i < s1.length() +1 ; i++){
            for(int j = 1; j < s2.length()+1 ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))  curr[j] = 1 + prev[j-1]; // f(i-1, j-1, s1 , s2);
                else curr[j] = Math.max( prev[j] ,curr[j-1]);
            }
            prev = curr.clone();
        }
        int lcs = prev[s2.length()];

        return s1.length() + s2.length() - (2 * lcs);
    }
    // int f(int i , int j , String s1 , String s2){

    //     if(i == 0 || j == 0) return 0;

    //     if(dp[i][j] != null) return dp[i][j];

    //     if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = 1 + f(i-1, j-1, s1 , s2);
    //     return dp[i][j] = Math.max(f(i-1 , j , s1 , s2) , f(i , j-1 , s1 , s2));
    // }
}