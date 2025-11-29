class Solution {
    Integer dp[][];
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()][word2.length()];
        return f(word1.length() -1 , word2.length() -1 , word1 , word2);
    }
    int f(int i , int j , String s1 , String s2){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != null) return dp[i][j] ;

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = f(i-1 , j-1 , s1 , s2);
        return dp[i][j] = 1 + Math.min((f(i-1 , j-1 , s1 , s2)) , Math.min( f(i , j-1 , s1 , s2) , f(i-1 , j , s1 , s2) ) );
    }
}