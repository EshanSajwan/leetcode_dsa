class Solution {
    // int[][] Dir = {{ -2 , 1} , {-1 , 2} , {1 , 2} , {2 , 1} ,
    //                {2 , -1} ,{1 , -2} , {-1 , -2} , {-2 , -1}};
    int[][] Dir = {{ 4 , 6} , { 6 , 8} , { 7 , 9} , {4 , 8} , {0 , 3 , 9} , {} ,
                   {1 , 7 , 0} , {2 , 6} , {1 , 3} , { 2 , 4}};
    record pair(int i , int n){}
    // Map<pair , Integer> set;
    int[][] memo ;
    static final int mod = 1_000_000_007;
    public int knightDialer(int n) {
        int ans = 0;
        // set = new HashMap<>();
        memo = new int[n + 1][10];
        for(int i = 0 ; i < n + 1 ; i++) Arrays.fill(memo[i] , -1);
        // for(int i = 0 ; i < 4 ; i++){
        //     for(int j = 0 ; j < 3 ; j++){
        //         ans += solve(i , j , n);
        //     }
        // }
        for(int i = 0 ; i < 10 ; i++) ans = (ans + (solve( n , i ) % mod)) % mod;
        // ans = (ans + (solve(3, 2 , n ) % mod)) % mod;
        return ans;
    }
    private int solve(int n , int i){
        // if(i < 0 || j < 0 || i >= 4 || j >= 3 || 
        //     (i == 3 && j == 0) || (i == 3 && j == 2)) return 0;
        // pair p = new pair( i , n );
        // if(set.containsKey(p)) return set.get(p);
        if( n == 1 ) return 1;
        if(memo[n][i] != -1) return memo[n][i];
        int ans = 0;
        for(int dir : Dir[i]){
            ans =  (ans + (solve( n - 1 , dir ) % mod)) % mod;
        }
        // set.put(p , ans);
        return memo[n][i] = ans;
    }
}