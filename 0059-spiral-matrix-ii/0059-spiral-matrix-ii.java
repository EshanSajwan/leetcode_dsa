class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int l = 0 , r = n - 1 , top = 0 , bottom = n - 1 , num = 1;
        while(l <= r && top <= bottom){
            for(int i = l ; i <= r ; i++) mat[top][i] = num++;
            top++;
            for(int i = top ; i <= bottom ; i++) mat[i][r] = num++;
            r--;
            for(int i = r ; i >= l ; i--) mat[bottom][i] = num++;
            bottom--;
            for(int i = bottom ; i >= top; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }
}