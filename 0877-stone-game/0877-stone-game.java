class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        dp = new Integer[piles.length][piles.length];
        int score = play(piles , 0 , piles.length - 1);
        return score > 0;
    }
    private int play(int[] piles , int start , int end){
        if(start == end) return piles[start];
        if(dp[start][end] != null) return dp[start][end];
        return dp[start][end] = 
            Math.max(piles[start] - play( piles , start + 1 , end) ,
                piles[end] - play( piles , start , end - 1));
    }
}