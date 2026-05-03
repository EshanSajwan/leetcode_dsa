class Solution {
    int m , n;
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        m = mat.length ; n = mat[0].length;
        if(m * n > r * c || (r >= m && c >= n)) return mat;
        if(c > r) return colMajor(mat , r , c);
        return rowMajor(mat , r , c);
    }
    private int[][] rowMajor(int[][] mat, int r, int c){
        
        for(int rowSize = 1 ; rowSize <= r ; rowSize++){
            if(c * rowSize == m * n) {
                r = rowSize;
                break;
            }
        }
        int i = 0 , j = 0 , x = 0 , y = 0;
        int[][] newMat = new int[r][c];
        while(i < m){
            newMat[x][y] = mat[i][j];
            j++;
            if(j == n){
                j = 0;
                i++;
            }
            y++;
            if(y == c){
                y = 0;
                x++;
            }
        }
        return newMat;
    }
    private int[][] colMajor(int[][] mat, int r, int c){

        for(int colSize = 1 ; colSize <= c ; colSize++){
            if(r * colSize == m * n) {
                c = colSize;
                break;
            }
        }
        int i = 0 , j = 0 , x = 0 , y = 0;
        int[][] newMat = new int[r][c];
        while(i < m){
            newMat[x][y] = mat[i][j];
            j++;
            if(j == n){
                j = 0;
                i++;
            }
            y++;
            if(y == c){
                y = 0;
                x++;
            }
        }
        return newMat;
    }
}