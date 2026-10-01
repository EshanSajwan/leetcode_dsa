class Solution {
    // Map<Integer , Integer> map;
    int[] freq ;
    Integer[] dp;
    public int deleteAndEarn(int[] nums) {
        // map = new HashMap<>();
        int maxi = 0;
        for( int num : nums) maxi = Math.max( maxi , num);
        freq = new int[maxi + 1];
        dp = new Integer[maxi + 1];
        for(int num : nums) freq[num]++;
        // map.put(num , map.getOrDefault(num , 0) + 1);
        return game(0);
    }
    private int game( int from ){
        if(from >= freq.length) return 0;
        if(dp[from] != null) return dp[from];
        if(freq[from] == 0) return dp[from] = game(from + 1);
        int take = from * freq[from] + game(from + 2);
        int notTake = game( from + 1) ;
        return dp[from] = Math.max( take , notTake );
    }
}