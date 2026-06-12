class Solution {
    int n;
    int[] b;
    int[] a;
    Long[][] dp;
    public long maxScore(int[] a, int[] b) {
        n = b.length;
        dp = new Long[4][n];
        this.b = b;
        this.a = a;
        return rec(0 , 0);
    }
    private long rec(int ai , int bj ){

        if(ai == 4) return 0;
        if(bj == n) return Long.MIN_VALUE / 10;

        if(dp[ai][bj] != null) return dp[ai][bj];

        long take = (long)a[ai] * b[bj] + rec(ai + 1 , bj + 1);
        long notTake = rec(ai , bj + 1);

        return dp[ai][bj] = Math.max(take , notTake);
    }
}