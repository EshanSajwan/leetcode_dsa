class Solution {
    // boolean[][] visit;
    int maxi = 1;
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // visit = new boolean[m][n];
        dp = new Integer[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                maxi = Math.max(maxi , dfs(i , j , matrix ));
            }
        }
        return maxi;
    }
    private int dfs(int i , int j , int[][] matrix ){
        // if(curr > maxi) maxi = curr;
        // visit[i][j] = true;
        if(dp[i][j] != null) return dp[i][j];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dR ={-1 , 0 , +1 , 0};
        int[] dC = {0 , +1 , 0 , -1};
        int curr = 1;
        for(int k = 0 ; k < 4; k++){
            int newR = i + dR[k] , newC = j + dC[k];
            if(newR > -1 && newR < m 
               && newC > -1 && newC < n 
            //    && !visit[newR][newC] 
               && matrix[newR][newC] > matrix[i][j])
                    curr = Math.max(curr , 1 + dfs(newR , newC , matrix ));
        }
        // visit[i][j] = false;
        return dp[i][j] = curr;
    }
}