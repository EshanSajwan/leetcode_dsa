class Solution {
    // Integer[][] dp;
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int i = s1.length() -1  , j = s2.length() -1;
        // dp = new Integer[i+2][j+2];
        int curr[] = new int[j+2];
        int prev[] = new int[j+2];
        // for(int x = 0 ; x < i + 2 ; x++) dp[x][0] = 0;
        // for(int y = 0 ; y < j + 2; y++) dp[0][y] = 0;
        // Arrays.fill(curr , 0);
        // Arrays.fill(prev ,0);
        for(int x = 1; x < i+ 2 ; x++){
            for(int y = 1 ; y < j+ 2 ; y++){
                if(s1.charAt(x-1) == s2.charAt(y-1)) 
                     curr[y] = 1 + prev[ y-1 ];
                //not Match
                else 
                     curr[y] = Math.max(prev[ y ] , curr[ y-1 ]);
            }
            prev = curr.clone();
        }
        int lcs = curr[j+1];// longestCommonSubSequence(s1 ,s2 , i , j);
        return lcs;
    }
}