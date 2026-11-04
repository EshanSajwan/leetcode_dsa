class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides , (a,b) -> Integer.compare(a[0] , b[0]));
        int m = rides.length;
        long[] dp = new long[m];
        Arrays.fill(dp , -1);
        return takeMax( 0 , rides , dp);
    }
    private long takeMax(int i , int[][] rides , long[] dp){
        if(i == rides.length) return 0;
        if(dp[i] != -1) return dp[i];
        long take = 0 , notTake = 0;
        // if(last == 0 || rides[last - 1][1] <= rides[i][0])
        
        int l = i + 1 , h = rides.length;
        while(l < h){
            int mid = l + (h - l) / 2;
            if(rides[mid][0] >= rides[i][1]) h = mid;
            else l = mid + 1;
        }
        take = rides[i][2] + rides[i][1] - rides[i][0] + 
                takeMax(l , rides , dp);

        notTake = takeMax(i + 1 , rides , dp);
        return dp[i] = Math.max(take , notTake);
    }
}