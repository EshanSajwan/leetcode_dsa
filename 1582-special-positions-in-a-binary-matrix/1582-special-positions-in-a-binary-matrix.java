class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 1 && isValid(i , j , mat)) count++;
            }
        }
        return count;
    }
    private boolean isValid(int i , int j , int[][] mat){
        for(int col = 0 ; col < mat[0].length  ; col++) if(mat[i][col] == 1 && col != j) return false;
        for(int row = 0 ; row < mat.length ; row++) if(mat[row][j] == 1 && row != i ) return false;
        return true;
    }
}