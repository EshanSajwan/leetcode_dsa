class Solution {
    // Boolean dp[][];
    public boolean isMatch(String s, String p) {
        // dp = new Boolean[s.length() +1][p.length() +1];
        boolean prev[] = new boolean[p.length() +1];
        boolean curr[] = new boolean[p.length() +1];
        // dp[0][0] = true; 
        prev[0]= true;
        // for(int i = 1 ; i < s.length() +1 ; i++) dp[i][0] = false;
        for(int j = 1 ; j < p.length() +1 ; j++) {
            boolean flag = true;
            int jj = j;
            while(jj > 0){
                if(p.charAt(jj-- -1) != '*') {
                    flag = false;
                    break;
                }
            }
            prev[j] = flag;
        }
        for(int i =  1; i < s.length() +1 ; i++){
            curr[0] = false;
            for(int j =  1 ;j < p.length() +1 ; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')  curr[j] =  prev[j-1]; // f(i-1 , j -1 , s , p);
                else if(p.charAt(j-1) == '*') curr[j] = curr[j-1] ||  prev[j]; // f(i , j-1 , s , p) || f(i -1, j , s , p);
                else curr[j] = false;
            }
            prev = curr.clone();
        }
        return  prev[p.length()];// f(s.length(), p.length() , s , p);
    }
    // boolean f(int i , int j , String s , String p){

    //     if(i == 0 && j == 0) return true;
    //     if(j == 0 && i > 0) return false;
    //     if(i == 0 ){
    //         while(j > 0){
    //             if(p.charAt(j-- -1) != '*') return false;
    //         }
    //         return true;
    //     }
    //     if(dp[i][j] != null) return dp[i][j];

    //     if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') return dp[i][j] = f(i-1 , j -1 , s , p);
    //     if(p.charAt(j-1) == '*') return dp[i][j] = f(i , j-1 , s , p) || f(i -1, j , s , p);
    //     return dp[i][j] = false;

    // }
}