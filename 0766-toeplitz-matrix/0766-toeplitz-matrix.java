class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        for(int j = 0 ; j < n ; j++){
            int jj = j;
            for(int i = 0 ; i < m - 1 ; i++){
                if(jj == n - 1) break;
                if(matrix[i][jj] != matrix[i + 1][jj + 1]) return false;
                jj++;
            }
        }
        for(int i = 1 ; i < m ; i++){
            int ii = i;
            for(int j = 0 ; j < n - 1; j++){
                if(ii == m - 1) break;
                if(matrix[ii][j] != matrix[ii + 1][j + 1]) return false;
                ii++;
            }
        }
        return true;
    }
}