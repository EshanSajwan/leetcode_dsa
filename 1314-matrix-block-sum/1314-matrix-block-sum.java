class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length , n = mat[0].length;
        int[][] ans = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            int sum = 0;
            for(int j = 0 ; j < n ; j++){
                sum += mat[i][j];
                mat[i][j] = sum;
            }
        }
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = 0 ; j < m ; j++){
                sum += mat[j][i];
                mat[j][i] = sum;
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int a = Math.min(m- 1 , i + k) , b = Math.min(n - 1, j + k) , sum = 0;
                // while(a >= m || b >= n){
                //     if(a >= m && b >= n){
                //         a--;
                //         b--;
                //     }
                //     else if(a >= m) a--;
                //     else b--;
                // }
                sum += mat[a][b];
                if(j - k - 1 > -1) sum -= mat[a][j - k - 1];
                if(i - k - 1 > -1) sum -= mat[i - k - 1][b];
                if(j - k - 1 > -1 && i - k - 1 > -1) sum += mat[i - k - 1][j - k - 1];
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}