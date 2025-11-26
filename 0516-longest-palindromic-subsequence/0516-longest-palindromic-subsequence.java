class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int[] prev = new int[s2.length() +1];
        int[] curr = new int[s2.length() +1];
        for(int j = 0 ; j < s2.length() +1 ; j++) prev[j] = 0;
        // for(int i = 0 ; i < s1.length() +1 ; i++) dp[i][0] = 0;
        for(int i = 1 ; i < s1.length() +1 ; i++){
            for(int j = 1; j < s2.length() +1 ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))  curr[j] = 1 + prev[j-1];
                else curr[j] = Math.max(prev[j] , curr[j-1]);
            }
            prev = curr.clone();
        }
        //  F(s1.length() , s2.length() , s1 , s2);
         return prev[s2.length()];
    }
}