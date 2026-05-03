class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if(len > m * n || len < m * n ) return new int[0][0];
        int index = 0;
        if(m < n){
            for(int i = 1 ; i < n + 1 ; i++){
                if(len == m * i){
                    n = i;
                    break;
                }
            }
        }
        else{
            for(int i = 1 ; i < m + 1 ; i++){
                if(len == n * i){
                    m = i;
                    break;
                }
            }
        }
        int[][] arr = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = original[index++];
                if(index == original.length) break;
            }
        }
        return arr;
    }
}