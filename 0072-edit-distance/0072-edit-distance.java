class Solution {
    // Integer dp[][];
    public int minDistance(String word1, String word2) {
        // dp = new Integer[word1.length() +1][word2.length() +1];

        int[] prev = new int [word2.length() +1];
        int[] curr = new int [word2.length() +1];


        // for(int i = 0 ; i < word1.length() +1 ; i++) dp[i][0] = i;
        for(int j = 0; j < word2.length() +1 ; j++) prev[j] = j;

        for(int i = 1 ; i < word1.length() +1 ; i++){
            curr[0] = i;
            for(int j = 1 ; j < word2.length() +1 ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))  curr[j] = prev[j-1] ; // f(i-1 , j-1 , s1 , s2);
                else curr[j] = 1 + Math.min(prev[j-1] , Math.min(curr[j-1] ,prev[j] ) );
            }
            prev = curr.clone();
        }
        return prev[word2.length()]; // f(word1.length() , word2.length() , word1 , word2);
    }
    // int f(int i , int j , String s1 , String s2){
    //     if(i == 0) return j;
    //     if(j == 0) return i;

    //     if(dp[i][j] != null) return dp[i][j] ;

    //     if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = f(i-1 , j-1 , s1 , s2);
    //     return dp[i][j] = 1 + Math.min((f(i-1 , j-1 , s1 , s2)) , Math.min( f(i , j-1 , s1 , s2) , f(i-1 , j , s1 , s2) ) );
    // }
}