class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        Integer[][] dp = new Integer[str1.length()+1][str2.length() +1];
        for(int i = 0 ; i < str2.length() +1 ; i++) dp[0][i] = 0;
        for(int i = 0 ; i < str1.length() +1 ; i++) dp[i][0] = 0;
        for(int i =1 ; i< str1.length() +1 ; i++){
            for(int j = 1 ; j < str2.length() +1 ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = str1.length() , j = str2.length();
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            } else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i > 0) sb.append(str1.charAt(i-- -1));
        while(j > 0) sb.append(str2.charAt(j-- -1));
        return sb.reverse().toString();

    }
}