class Solution {
    long[] dp;
    int mod = 1_000_000_007;
    public int numDecodings(String s) {
        dp = new long[s.length()];
        Arrays.fill(dp , -1);
        return (int)solve( 0 , s );
        // return 1;
    }
    private long solve( int i , String s){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        long a = 0 , b = 0 , c = 0 , d = 0 , e = 0 , f = 0 , g = 0;
        if(s.charAt(i) == '*'){
            d = (9 * (solve(i + 1 , s) % mod)) % mod;
            if(i + 1 < s.length() && s.charAt(i + 1) != '*')
            e = solve(i + 2 , s) % mod;
            if(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6') 
            f = solve(i + 2 , s) % mod;
            if(i + 1 < s.length() && s.charAt(i + 1) == '*')
            g = (15 * (solve(i + 2 , s) % mod)) % mod;
        }
        else{
            a = solve(i + 1 , s) % mod;
            if(i + 1 < s.length() && s.charAt(i) == '1' ){
                if(s.charAt(i + 1) == '*') b = (9 * (solve(i + 2 , s) % mod)) % mod;
                else b = solve(i + 2 , s) % mod;
            }
            if(i + 1 < s.length() && s.charAt(i) == '2' ){
                if(s.charAt(i + 1) == '*') c = (6 * (solve(i + 2 , s) % mod)) % mod;
                else if(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'){
                    c = solve(i + 2 , s) % mod;
                }
            }
            
        }
        return dp[i] = (a + b + c + d + e + f + g) % mod;
    }
}