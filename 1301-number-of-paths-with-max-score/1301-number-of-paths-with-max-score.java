class Solution {
    record pair(int i, int j){}
    List<String> grid;
    int n;
    Map<pair , int[]> dp;
    public int[] pathsWithMaxScore(List<String> board) {
        this.grid = board;
        this.n = grid.size();
        dp = new HashMap<>();
        grid.set(0 , "0" + grid.get(0).substring(1));
        grid.set(n - 1 , grid.get(n-1).substring(0 , n - 1) + "0");
        int[] ans = rec(n - 1 , n - 1);
        if(ans[0] == -1) return new int[]{0 , 0};
        return ans;
    }
    private int[] rec(int i , int j){
        if(i == 0 && j == 0) return new int[]{0 , 1};

        if(i < 0 || j < 0 || grid.get(i).charAt(j) == 'X' ) return new int[]{-1 , -1};
        
        pair node = new pair(i , j);

        if(dp.containsKey( node )) return dp.get( node );

        int[] left = rec(i , j - 1);
        int[] up_left = rec(i - 1 , j - 1);
        int[] up = rec(i - 1, j);

        int maxSum = Math.max( left[0] , Math.max( up_left[0] , up[0]));
        
        if(maxSum == -1) {
            int[] arr = new int[]{-1 , -1};
            dp.put( node , arr);
            return arr;
        }

        int count = 0;
        if(left[0] == maxSum) count = (count + left[1]) % 1_000_000_007 ;
        if(up_left[0] == maxSum) count = (count + up_left[1]) % 1_000_000_007 ;
        if(up[0] == maxSum) count = (count + up[1]) % 1_000_000_007 ;
        
        int[] arr = new int[]{ (grid.get(i).charAt(j) - '0' + maxSum) % 1_000_000_007 , count };
        dp.put(node , arr);
        return arr;
    }
}