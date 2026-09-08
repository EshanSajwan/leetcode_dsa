class Solution {
    // int[][] dp;
    record pair(int a , int b){}
    int mod = 1_000_000_007;
    Map<pair , Integer> map;
    public int numWays(int steps, int arrLen) {
        // agar vo x pe hai or stepsRemaining is lass than x return 0;
        // dp = new int[arrLen][steps + 1];
        // for(int i = 0 ; i < arrLen ; i++) Arrays.fill( dp[i] , -1);
        map = new HashMap<>();
        return rec( 0 , steps , arrLen);
    }
    private int rec(int pos , int steps , int arrLen){
        if(pos < 0 || pos == arrLen) return 0;
        if(steps == 0){
            return pos == 0 ? 1 : 0;
        }
        // if(dp[pos][steps] != -1) return dp[pos][steps];
        pair p = new pair(pos , steps);
        if(map.containsKey(p)) return map.get(p);
         int x =
                ((rec(pos - 1 , steps - 1 , arrLen) % mod +
                rec(pos , steps - 1 , arrLen) % mod) % mod +
                rec( pos + 1 , steps - 1 , arrLen) % mod ) % mod;
        map.put(p , x);
        return x;
    }
}